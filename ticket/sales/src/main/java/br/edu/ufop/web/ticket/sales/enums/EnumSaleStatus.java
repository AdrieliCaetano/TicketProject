package br.edu.ufop.web.ticket.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSaleStatus {
    
    EMABERTO(1, "Em aberto"),
    PAG0(2,"Pago"),
    CANCELADO(3, "Cancelado"),
    ESTORNADO(4, "Estornado");
    // OUTRO(5, "Outro");

    private Integer id;
    private String description;
}
