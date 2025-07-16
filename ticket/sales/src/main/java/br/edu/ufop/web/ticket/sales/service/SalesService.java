package br.edu.ufop.web.ticket.sales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.sales.converter.SalesConverter;
import br.edu.ufop.web.ticket.sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.DeleteSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.UpdateSaleDTO;
import br.edu.ufop.web.ticket.sales.models.EventModel;
import br.edu.ufop.web.ticket.sales.models.SalesModel;
import br.edu.ufop.web.ticket.sales.repositories.IEventRepository;
import br.edu.ufop.web.ticket.sales.repositories.ISalesRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SalesService {
    
    private final ISalesRepository salesRepository;
    private final IEventRepository eventRepository;

    public List<SimpleSalesRecordDTO> getAllSales(){
        
        List<SalesModel> salesModelList = salesRepository.findAll();
        
        return salesModelList.stream().map(SalesConverter::toSimpleSalesRecordDTO).toList();
    }

    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO){

        SalesDomain salesDomain = SalesConverter.toSalesDomain(createSaleDTO);

        // use case

        Optional<EventModel> optional = eventRepository.findById(createSaleDTO.getEvent_id());

        if (optional.isEmpty()){
            return null;
        }

        EventModel eventModel = optional.get();

        SalesModel salesModel = SalesConverter.toSalesModel(salesDomain);
        
        salesModel.setEventModel(eventModel);


        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(salesModel));

    }

    public SimpleSalesRecordDTO updateSale(UpdateSaleDTO updateSaleDTO){

        SalesDomain salesDomain = SalesConverter.toSalesDomain(updateSaleDTO);

        Optional<SalesModel> optionalSalesModel = salesRepository.findById(updateSaleDTO.getId());

        if (optionalSalesModel.isEmpty()){
            return null;
        }

        Optional<EventModel> optionalEventModel = eventRepository.findById(updateSaleDTO.getEvent_id());

        if (optionalEventModel.isEmpty()){
            return null;
        }

        EventModel eventModel = optionalEventModel.get();

        SalesModel salesModel = SalesConverter.toSalesModel(salesDomain);
        
        salesModel.setEventModel(eventModel);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(salesModel));
    }

    public void deleteSale(DeleteSaleDTO deleteSaleDTO){

        Optional<SalesModel> optionalSalesModel = salesRepository.findById(deleteSaleDTO.id());

        if(optionalSalesModel.isEmpty()){
            throw new RuntimeException("Sale not found.");
        }

        salesRepository.delete(optionalSalesModel.get());

    }

}
