package com.jds.springboot.core.app.springboot_jds.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_mst_producto_existencias")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_producto", nullable = false)
    private Long productId;

    @Column(name = "id_bodega", nullable = false)
    private Long warehouseId;

    @Column(name = "cantInicial", nullable = false, precision = 16, scale = 2)
    private BigDecimal initialQuantity;

    @Column(name = "cantActual", nullable = false, precision = 16, scale = 2)
    private BigDecimal currentQuantity;

    @Column(name = "compras", nullable = false, precision = 16, scale = 2)
    private BigDecimal purchases;

    @Column(name = "ventas", nullable = false, precision = 16, scale = 2, columnDefinition = "decimal(16,2) default '0.00'")
    private BigDecimal sales = BigDecimal.ZERO;

    @Column(name = "devoluciones", nullable = false, precision = 16, scale = 2, columnDefinition = "decimal(16,2) default '0.00'")
    private BigDecimal returns = BigDecimal.ZERO;

    @Column(name = "remisionada", nullable = false, precision = 12, scale = 2, columnDefinition = "decimal(12,2) unsigned default '0.00'")
    private BigDecimal remitted = BigDecimal.ZERO;

    @Column(name = "origenAjuste", nullable = false, columnDefinition = "int default '0'")
    private Long adjustmentSource = 0L;

    @Column(name = "cantUltimoAjuste", nullable = false, columnDefinition = "int default '0'")
    private Long lastAdjustmentQuantity = 0L;

    @Column(name = "codUltimoAjuste", nullable = false, columnDefinition = "int default '0'")
    private Long lastAdjustmentCode = 0L;

    // Default constructor
    public Stock() {}

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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(BigDecimal initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public BigDecimal getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(BigDecimal currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public BigDecimal getPurchases() {
        return purchases;
    }

    public void setPurchases(BigDecimal purchases) {
        this.purchases = purchases;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getReturns() {
        return returns;
    }

    public void setReturns(BigDecimal returns) {
        this.returns = returns;
    }

    public BigDecimal getRemitted() {
        return remitted;
    }

    public void setRemitted(BigDecimal remitted) {
        this.remitted = remitted;
    }

    public Long getAdjustmentSource() {
        return adjustmentSource;
    }

    public void setAdjustmentSource(Long adjustmentSource) {
        this.adjustmentSource = adjustmentSource;
    }

    public Long getLastAdjustmentQuantity() {
        return lastAdjustmentQuantity;
    }

    public void setLastAdjustmentQuantity(Long lastAdjustmentQuantity) {
        this.lastAdjustmentQuantity = lastAdjustmentQuantity;
    }

    public Long getLastAdjustmentCode() {
        return lastAdjustmentCode;
    }

    public void setLastAdjustmentCode(Long lastAdjustmentCode) {
        this.lastAdjustmentCode = lastAdjustmentCode;
    }

    
}
