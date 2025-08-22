package br.edu.ufop.web.notifications.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumNotificationType {

    MESSAGE(0, "Message"),
    EMAIL(1, "Email"),
    WHATSAPP(2, "Whatsapp"),
    TELEGRAM(3, "Telegram");

    private Integer id;
    private String description;

}