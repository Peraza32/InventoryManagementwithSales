package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "user_name")
    private String name;

    @Column
    private String lastname;

    @Column(name = "doc")
    private String document;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private Date birthdate;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserType user_type_id;
}
