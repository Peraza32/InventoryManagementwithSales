package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @Column
    private int quantity;

    @Column
    private float total;

    @Column
    private float discount;

    public OrderDetail(int quantity, float total, float discount) {
        this.quantity = quantity;
        this.total = total;
        this.discount = discount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne
    private Order order;
}
