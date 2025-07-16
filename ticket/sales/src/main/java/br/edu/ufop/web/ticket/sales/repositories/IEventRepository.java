package br.edu.ufop.web.ticket.sales.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.ticket.sales.models.EventModel;
import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
import java.time.LocalDateTime;



public interface IEventRepository extends JpaRepository<EventModel, UUID>{
    
    List<EventModel> findByType(EnumEventType type);
    List<EventModel> findByDate(LocalDateTime date);

}
