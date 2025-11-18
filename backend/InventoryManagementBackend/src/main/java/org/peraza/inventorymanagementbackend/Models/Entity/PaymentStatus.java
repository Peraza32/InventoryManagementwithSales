package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payment_status")
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_status_id")
    private int paymentStatusId;

    @Column(name = "payment_status")
    private String paymentStatusName;

    @OneToMany(mappedBy = "payment_status", fetch = FetchType.LAZY)
    private List<Order> orders;
}
