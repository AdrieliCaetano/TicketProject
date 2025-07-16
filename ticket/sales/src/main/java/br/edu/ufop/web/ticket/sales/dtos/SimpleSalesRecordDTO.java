package br.edu.ufop.web.ticket.sales.dtos;

import java.util.UUID;

public record SimpleSalesRecordDTO( UUID id, UUID user_id, UUID event_id) {

}
