package br.edu.ufop.web.ticket.sales.repositories;

//import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.ticket.sales.models.SalesModel;

public interface ISalesRepository extends JpaRepository<SalesModel, UUID> {
    
    //List<SalesModel> findByUserId(UUID user_id);
}
