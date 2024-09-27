package com.manager.products.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}