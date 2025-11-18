package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payment_type")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private int paymentTypeId;

    @Column(name = "payment_type")
    private String paymentTypeName;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "payment_type")
    private List<Order> orders;
}
