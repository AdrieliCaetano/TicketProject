package br.ufop.edu.web.ticket.user.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufop.edu.web.ticket.user.enums.EnumUserType;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain {

    private UUID id;
    private String name;

    // ...

    private String creditCardNumber;

    private String email;
    private String password;

    private String city;

    private CreditCardNetworkDomain creditCardNetworkDomain;

    private EnumUserType userType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
