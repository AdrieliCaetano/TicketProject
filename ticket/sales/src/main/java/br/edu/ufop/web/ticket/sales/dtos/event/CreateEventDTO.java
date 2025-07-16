package br.edu.ufop.web.ticket.sales.dtos.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventDTO {
    
    private String description;

    private EnumEventType type;

    private LocalDateTime date;
    private LocalDateTime startSales;
    private LocalDateTime endSales;

    private Float price;
}
