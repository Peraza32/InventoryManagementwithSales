package org.peraza.inventorymanagementbackend.Models.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int categoryId;

    @Column(name="category_name",length=100, nullable=false)
    private String  categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // Relationships
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "category")
    private List<Subcategory> subcategories;
}
