package br.edu.ufop.web.ticket.sales.models;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sales")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID user_id;
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel eventModel;

    private LocalDateTime saleDate;
    
    private EnumSaleStatus saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void antesGravar(){
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar(){
        this.updateAt = LocalDateTime.now();
    }

}
