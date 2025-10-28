package org.peraza.inventorymanagementbackend.Models.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Provider {
    private UUID providerId;
    private String providerName;
    private String phoneNumber;
    private String email;
}
