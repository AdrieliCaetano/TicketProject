package br.edu.ufop.web.ticket.sales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.sales.converter.EventConverter;
import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.dtos.event.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.DeleteEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.SimpleEventRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.UpdateEventDTO;
import br.edu.ufop.web.ticket.sales.models.EventModel;
import br.edu.ufop.web.ticket.sales.repositories.IEventRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService {
    
    private final IEventRepository eventRepository;

    public List<SimpleEventRecordDTO> getAllEvents(){

        List<EventModel> eventModelList = eventRepository.findAll();

        return eventModelList.stream().map(EventConverter::toSimpleEventRecordDTO).toList();

    }

    public SimpleEventRecordDTO createEvent(CreateEventDTO createEventDTO){

        EventDomain eventDomain = EventConverter.toEventDomain(createEventDTO);

        // use case

        EventModel eventModel = EventConverter.toEventModel(eventDomain);

        return EventConverter.toSimpleEventRecordDTO(eventRepository.save(eventModel));

    }

    public SimpleEventRecordDTO updateEvent(UpdateEventDTO updateEventDTO){

        EventDomain eventDomain = EventConverter.toEventDomain(updateEventDTO);

        // use cases

        Optional<EventModel> optionalEventModel = eventRepository.findById(updateEventDTO.getId());

        if (optionalEventModel.isEmpty())
        {
            return null;
        }

        EventModel eventModel = EventConverter.toEventModel(eventDomain);

        return EventConverter.toSimpleEventRecordDTO(eventRepository.save(eventModel));
    }

    public void deleteEvent(DeleteEventDTO deleteEventDTO){

        Optional<EventModel> optionalEventModel = eventRepository.findById(deleteEventDTO.id());

        if (optionalEventModel.isEmpty()) {
            throw new RuntimeException("Event not found.");
        }

        eventRepository.delete(optionalEventModel.get());

    }



}
