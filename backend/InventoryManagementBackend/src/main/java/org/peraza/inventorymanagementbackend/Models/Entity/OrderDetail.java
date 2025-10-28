package org.peraza.inventorymanagementbackend.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetail {
    private int orderDetailId;
    private int quantity;
    private float total;
    private float discount;

    public OrderDetail(int quantity, float total, float discount) {
        this.quantity = quantity;
        this.total = total;
        this.discount = discount;
    }
}
