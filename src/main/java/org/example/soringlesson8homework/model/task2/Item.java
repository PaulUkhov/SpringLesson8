package org.example.soringlesson8homework.model.task2;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private Long id;
    private String name;
    private int availableQuantity;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ItemStatus status;
}
