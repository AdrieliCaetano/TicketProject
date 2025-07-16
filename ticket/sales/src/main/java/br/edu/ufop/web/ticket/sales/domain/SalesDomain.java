package br.edu.ufop.web.ticket.sales.domain;

import java.time.LocalDateTime;
import java.util.UUID;

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
public class SalesDomain {
    
    private UUID id;
    private UUID user_id;
    
    // private UUID event_id;
    private EventDomain eventDomain;

    private LocalDateTime saleDate;
    
    private EnumSaleStatus saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
