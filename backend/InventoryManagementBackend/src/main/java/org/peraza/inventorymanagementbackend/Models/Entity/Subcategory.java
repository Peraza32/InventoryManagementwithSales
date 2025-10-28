package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subCategoryId;

    @Column(name = "subcategory_name", length = 100,  nullable = false)
    private String subCategoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
