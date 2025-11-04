package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "product_id")
    private UUID productId;

    @Column(name = "product_name")
    private String productName;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private int quantity;

    @ManyToOne
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subcategory subcategory;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;



}
