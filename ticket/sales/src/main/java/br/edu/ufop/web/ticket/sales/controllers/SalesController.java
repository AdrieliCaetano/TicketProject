package br.edu.ufop.web.ticket.sales.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.DeleteSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.UpdateSaleDTO;
import br.edu.ufop.web.ticket.sales.service.SalesService;
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

    @GetMapping
    public ResponseEntity<List<SimpleSalesRecordDTO>> getAllSales(){

        List<SimpleSalesRecordDTO> list = salesService.getAllSales();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SimpleSalesRecordDTO> getSaleById(@PathVariable(value = "saleId") String id) {

        SimpleSalesRecordDTO simpleSalesRecordDTO = salesService.getSaleById(id);

        if (simpleSalesRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simpleSalesRecordDTO);

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
