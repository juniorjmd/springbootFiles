package com.jds.springboot.core.app.springboot_jds.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_mst_producto_images")
public class Image { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_producto", nullable = false)
    private Long productId;

    @Column(name = "descripcion", nullable = false, length = 45, columnDefinition = "varchar(45) default 'imangen generica para un producto'")
    private String description = "imangen generica para un producto";

    @Column(name = "url", nullable = false, length = 45, columnDefinition = "varchar(45) default '/assets/prd_mst_productos_images/noImagen.png'")
    private String url = "/assets/prd_mst_productos_images/noImagen.png";

    @Column(name = "name", nullable = false, length = 45, columnDefinition = "varchar(45) default 'sin imagen'")
    private String name = "sin imagen";

    // Default constructor
    public Image() {}

    // Constructor with all arguments
    public Image(Long productId, String description, String url, String name) {
        this.productId = productId;
        this.description = description;
        this.url = url;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
