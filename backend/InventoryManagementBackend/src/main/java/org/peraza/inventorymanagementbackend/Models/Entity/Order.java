package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "delivery_status")
    private int deliveryStatus; // This will be treaded as an enum

    public Order(LocalDateTime orderDate, int deliveryStatus) {
        this.orderDate = orderDate;
        this.deliveryStatus = deliveryStatus;
    }

    //Relationships

    @ManyToOne(cascade = CascadeType.ALL)
    private User user_id;

    @OneToOne(cascade = CascadeType.ALL)
    private Ticket ticket_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentStatus payment_status;

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentType payment_type;

}
