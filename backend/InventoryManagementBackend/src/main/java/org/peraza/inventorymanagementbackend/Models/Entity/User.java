package org.peraza.inventorymanagementbackend.Models.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
public class User {
    private UUID id;
    private String name;
    private String lastname;
    private String document;
    private String phoneNumber;
    private String email;
    private Date birthdate;
}
