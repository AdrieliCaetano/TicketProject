package br.edu.ufop.web.ticket.sales.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.sales.dtos.event.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.DeleteEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.SimpleEventRecordDTO;
import br.edu.ufop.web.ticket.sales.dtos.event.UpdateEventDTO;
import br.edu.ufop.web.ticket.sales.service.EventService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    
    @GetMapping
    public ResponseEntity<List<SimpleEventRecordDTO>> getAllEvents(){

        List<SimpleEventRecordDTO> list = eventService.getAllEvents();
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{eventId}")
    public ResponseEntity<SimpleEventRecordDTO> getEventById(@PathVariable(value = "eventId") String id) {

        SimpleEventRecordDTO simpleeventRecordDTO = eventService.getEventById(id);

        if (simpleeventRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simpleeventRecordDTO);

    }

    @PostMapping
    public ResponseEntity<SimpleEventRecordDTO> createEvent(@RequestBody CreateEventDTO createEventDTO){
     
        SimpleEventRecordDTO simpleEventRecordDTO = eventService.createEvent(createEventDTO);
        return ResponseEntity.ok(simpleEventRecordDTO);
    }

    @PutMapping
    public ResponseEntity<SimpleEventRecordDTO> updateEvent(@RequestBody UpdateEventDTO updateEventDTO){

        SimpleEventRecordDTO simpleEventRecordDTO = eventService.updateEvent(updateEventDTO);

        if (simpleEventRecordDTO == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simpleEventRecordDTO);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteEvent(@RequestBody DeleteEventDTO deleteEventDTO){

        eventService.deleteEvent(deleteEventDTO);
        return ResponseEntity.ok("Event has been deleted.");

    }

    
}
