package br.edu.ufop.web.ticket.sales.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.DeleteSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.UpdateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.externals.users.UserDTO;
import br.edu.ufop.web.ticket.sales.service.SalesService;
import br.edu.ufop.web.ticket.sales.service.clients.UserServiceClient;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SalesController {
    
    private final SalesService salesService;
    private final UserServiceClient userServiceClient;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Sales service is running.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userServiceClient.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales(){

        List<SaleDTO> list = salesService.getAllSales();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable(value = "saleId") String id) {

        SaleDTO saleDTO = salesService.getSaleById(id);

        if (saleDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(saleDTO);

    }

    @PostMapping
    public ResponseEntity<SimpleSalesRecordDTO> createSale(@RequestBody CreateSaleDTO createSaleDTO){

        SimpleSalesRecordDTO simpleSalesRecordDTO = salesService.createSale(createSaleDTO);
        if (simpleSalesRecordDTO == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(simpleSalesRecordDTO);

    }

    @PutMapping
    public ResponseEntity<SimpleSalesRecordDTO> updateSale(@RequestBody UpdateSaleDTO updateSaleDTO){

        SimpleSalesRecordDTO simpleSalesRecordDTO = salesService.updateSale(updateSaleDTO);

        if (simpleSalesRecordDTO == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(simpleSalesRecordDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteSale(@RequestBody DeleteSaleDTO deleteSaleDTO){

        salesService.deleteSale(deleteSaleDTO);
        return ResponseEntity.ok("Sale has been deleted.");

    }
    
}
