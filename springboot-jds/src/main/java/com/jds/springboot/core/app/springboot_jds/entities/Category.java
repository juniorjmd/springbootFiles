package com.jds.springboot.core.app.springboot_jds.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 45)
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "categoriaPadre")
    private Long parentCategory;

    // Default constructor
    public Category() {}

    // Constructor with all arguments
    public Category(String name, String description, Long parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }
}
