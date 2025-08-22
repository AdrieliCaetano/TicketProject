package br.edu.ufop.web.ticket.sales.converter;

import br.edu.ufop.web.ticket.sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.UpdateSaleDTO;
import br.edu.ufop.web.ticket.sales.models.SalesModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class SalesConverter {
    
    public static SimpleSalesRecordDTO toSimpleSalesRecordDTO(SalesModel salesModel){
        return new SimpleSalesRecordDTO(
            salesModel.getId(),
            salesModel.getUser_id(),
            salesModel.getEventModel().getId()
        );
    }

    public static SaleDTO toSaleDTO(SalesModel saleModel) {

        return SaleDTO.builder()
            .id(saleModel.getId())
            .user_id(saleModel.getUser_id())
            .event(EventConverter.toEventDTO(saleModel.getEventModel()))
            .saleDate(saleModel.getSaleDate())
            .saleStatus(saleModel.getSaleStatus())
            .createdAt(saleModel.getCreatedAt())
            .updatedAt(saleModel.getUpdatedAt())
            .build();

    }

    public static SalesDomain toSalesDomain(CreateSaleDTO createSaleDTO) {
        return SalesDomain.builder()
            .user_id(createSaleDTO.getUser_id())
            .saleDate(createSaleDTO.getSaleDate())
            .saleStatus(createSaleDTO.getSaleStatus())
            .build();
    }

    public static SalesModel toSalesModel(SalesDomain salesDomain){
        return SalesModel.builder()
            .id(salesDomain.getId())
            .user_id(salesDomain.getUser_id())
            .saleDate(salesDomain.getSaleDate())
            .saleStatus(salesDomain.getSaleStatus())
            .build();
    }

    public static SalesDomain toSalesDomain(UpdateSaleDTO updateSaleDTO) {
        return SalesDomain.builder()
            .id(updateSaleDTO.getId())
            .user_id(updateSaleDTO.getUser_id())
            .saleDate(updateSaleDTO.getSaleDate())
            .saleStatus(updateSaleDTO.getSaleStatus())
            .build();
    }

}
