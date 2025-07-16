package br.edu.ufop.web.ticket.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumEventType {
    
    PALESTRA(1, "Palestra"),
    SHOW(2,"Show"),
    TEATRO(3, "Teatro"),
    CURSO(4, "Curso");
    // OUTRO(5, "Outro");


    private Integer id;
    private String description;
}
