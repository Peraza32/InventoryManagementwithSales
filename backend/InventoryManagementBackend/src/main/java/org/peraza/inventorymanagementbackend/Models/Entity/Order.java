package org.peraza.inventorymanagementbackend.Models.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private LocalDateTime orderDate;
    private int deliveryStatus; // This will be treaded as an enum
}
