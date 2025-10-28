package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private UUID ticketId;

    @Column(name="total_sale")
    private float totalSale;

    @Column(name = "generation_date")
    private LocalDateTime generationDate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ticket_id")
    private Order order;
}
