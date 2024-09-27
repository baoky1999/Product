package com.manager.products.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "style")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
