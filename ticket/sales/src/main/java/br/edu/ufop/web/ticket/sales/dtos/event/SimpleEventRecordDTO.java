package br.edu.ufop.web.ticket.sales.dtos.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record SimpleEventRecordDTO(UUID id, LocalDateTime date, Float price) {
    
}
