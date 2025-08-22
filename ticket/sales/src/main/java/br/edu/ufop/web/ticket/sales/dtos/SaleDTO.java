package br.edu.ufop.web.ticket.sales.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.ticket.sales.dtos.event.EventDTO;
import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {
    private UUID id;

    private UUID user_id;

    private EventDTO event;
    
    private LocalDateTime saleDate;
    
    private EnumSaleStatus saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}