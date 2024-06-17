package com.jds.springboot.core.app.springboot_jds.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_mst_producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idProducto", nullable = false, length = 100)
    private String idProducto;

    @Column(name = "idCategoria", nullable = false, length = 100)
    private String idCategoria;

    @Column(name = "idMarca", nullable = false)
    private Long idMarca;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "aux_nombre1", nullable = false, length = 150)
    private String auxNombre1;

    @Column(name = "aux_nombre2", nullable = false, length = 150)
    private String auxNombre2;

    @Column(name = "aux_nombre3", nullable = false, length = 150)
    private String auxNombre3;

    @Column(name = "porcent_iva", nullable = false, precision = 3, scale = 2)
    private BigDecimal porcentIva;

    @Column(name = "stock", nullable = false, precision = 16, scale = 2)
    private BigDecimal stock;

    @Column(name = "barcode", nullable = false, length = 100)
    private String barcode;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion = "DESCRIPCION GENERICA DEL PRODUCTO";

    @Column(name = "tipo_producto", nullable = false, length = 4, columnDefinition = "varchar(4) default 'PT'")
    private String tipoProducto = "PT";

    @Column(name = "fecha_creacion", nullable = false )
    private Date fechaCreacion;

    @Column(name = "referencia_externa", nullable = false, columnDefinition = "text")
    private String referenciaExterna;

    @Column(name = "iva_incluido")
    private boolean ivaIncluido = true;

    @JoinColumn(name = "id_producto")
    @OneToMany
    private List<Price> prices ;     
    @JoinColumn(name = "id_producto")
    @OneToMany
    private List<Image> images ; 
    @JoinColumn(name = "id_producto")
    @OneToMany
    private List<Stock> stocks ; 

/* @Column(name = "idCategoria", nullable = false, length = 100)
    private String idCategoria;

    @Column(name = "idMarca", nullable */
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private  Category category ; 

    public Product() {
        this.images = new ArrayList<>();
        prices = new ArrayList<>();
        stocks = new ArrayList<>(); 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAuxNombre1() {
        return auxNombre1;
    }

    public void setAuxNombre1(String auxNombre1) {
        this.auxNombre1 = auxNombre1;
    }

    public String getAuxNombre2() {
        return auxNombre2;
    }

    public void setAuxNombre2(String auxNombre2) {
        this.auxNombre2 = auxNombre2;
    }

    public String getAuxNombre3() {
        return auxNombre3;
    }

    public void setAuxNombre3(String auxNombre3) {
        this.auxNombre3 = auxNombre3;
    }

    public BigDecimal getPorcentIva() {
        return porcentIva;
    }

    public void setPorcentIva(BigDecimal porcentIva) {
        this.porcentIva = porcentIva;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    public boolean isIvaIncluido() {
        return ivaIncluido;
    }

    public void setIvaIncluido(boolean ivaIncluido) {
        this.ivaIncluido = ivaIncluido;
    }
}
