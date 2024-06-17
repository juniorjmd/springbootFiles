package com.jds.springboot.core.app.springboot_jds.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_mst_producto_precios")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_producto", nullable = false)
    private Long productId;

    @Column(name = "precioConIva", nullable = false, precision = 16, scale = 2)
    private BigDecimal priceWithTax;

    @Column(name = "precioAntesDeIVA", nullable = false, precision = 16, scale = 2)
    private BigDecimal priceBeforeTax;

    @Column(name = "valorIVA", nullable = false, precision = 16, scale = 2)
    private BigDecimal taxValue;

    @Column(name = "tipoPrecio", nullable = false, length = 10)
    private String priceType;

    // Default constructor
    public Price() {}

    // Constructor with all arguments
    public Price(Long productId, BigDecimal priceWithTax, BigDecimal priceBeforeTax, BigDecimal taxValue, String priceType) {
        this.productId = productId;
        this.priceWithTax = priceWithTax;
        this.priceBeforeTax = priceBeforeTax;
        this.taxValue = taxValue;
        this.priceType = priceType;
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

    public BigDecimal getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(BigDecimal priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public BigDecimal getPriceBeforeTax() {
        return priceBeforeTax;
    }

    public void setPriceBeforeTax(BigDecimal priceBeforeTax) {
        this.priceBeforeTax = priceBeforeTax;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    

}
