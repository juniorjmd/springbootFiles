package com.jds.springboot.core.app.springboot_jds.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_bodegas")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "tipo", columnDefinition = "varchar(3) default 'PV'")
    private String type = "PV";

    // Default constructor
    public Warehouse() {}

    // Constructor with all arguments
    public Warehouse(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }



}
