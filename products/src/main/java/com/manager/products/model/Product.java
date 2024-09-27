    package com.manager.products.model;

    import jakarta.persistence.*;
    import lombok.Data;

    @Data
    @Entity
    @Table(name = "product")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String image;

        @ManyToOne
        @JoinColumn(name = "color_id", nullable = false)
        private Color color;

        @ManyToOne
        @JoinColumn(name = "category_id", nullable = false)
        private Category category;

        @ManyToOne
        @JoinColumn(name = "style_id", nullable = false)
        private Style style;

        private double price;

        @ManyToOne
        @JoinColumn(name = "size_id", nullable = false)
        private Size size;
    }