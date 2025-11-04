package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "provider")
@Data
@NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private UUID providerId;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "provider")
    private List<Product> product;
}
