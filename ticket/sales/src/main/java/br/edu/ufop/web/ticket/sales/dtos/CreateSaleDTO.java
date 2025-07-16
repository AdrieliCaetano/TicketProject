package br.edu.ufop.web.ticket.sales.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleDTO {
    
    private UUID user_id;

    private UUID event_id;

    private LocalDateTime saleDate;

   private EnumSaleStatus saleStatus; 
}
