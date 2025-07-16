package br.edu.ufop.web.ticket.sales.converter;

import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.dtos.event.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.SimpleEventRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.UpdateEventDTO;
import br.edu.ufop.web.ticket.sales.models.EventModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventConverter {

    public static SimpleEventRecordDTO toSimpleEventRecordDTO(EventModel eventModel){
        return new SimpleEventRecordDTO(
            eventModel.getId(),
            eventModel.getDate(),
            eventModel.getPrice()
        );
    }

    public static EventDomain toEventDomain(CreateEventDTO createEventDTO){
        return EventDomain.builder()
            .description(createEventDTO.getDescription())
            .type(createEventDTO.getType())
            .date(createEventDTO.getDate())
            .startSales(createEventDTO.getStartSales())
            .endSales(createEventDTO.getEndSales())
            .price(createEventDTO.getPrice())
            .build();
    }

    public static EventModel toEventModel(EventDomain eventDomain){
        return EventModel.builder()
            .id(eventDomain.getId())
            .description(eventDomain.getDescription())
            .type(eventDomain.getType())
            .date(eventDomain.getDate())
            .startSales(eventDomain.getStartSales())
            .endSales(eventDomain.getEndSales())
            .price(eventDomain.getPrice())
            .build();
    }

    public static EventDomain toEventDomain(UpdateEventDTO updateEventDTO){
        return EventDomain.builder()
            .id(updateEventDTO.getId())
            .description(updateEventDTO.getDescription())
            .type(updateEventDTO.getType())
            .date(updateEventDTO.getDate())
            .startSales(updateEventDTO.getStartSales())
            .endSales(updateEventDTO.getEndSales())
            .price(updateEventDTO.getPrice())
            .build();
    }
    
}
