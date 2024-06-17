package com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="clients")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 

    private String name;

    private String lastname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "tbl_clientes_to_direcciones" , joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name="id_direcciones"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones" } ))
    private List<Address> addresses;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "client")
    private List<Invoice> invoices; 
     
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private ClientDetails clienteDetails;

    public List<Address> getAddresses() {
        return addresses;
    } 

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }



    public Client() {
        invoices = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    

    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    @Override
    public String toString() {
        return "{id=" + id + 
        ", name=" + name + 
        ", lastname=" + lastname + 
        ", addresses=" + addresses + 
        ", invoices=" + invoices + 
        "}";
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
        this.invoices.forEach((in)-> {
            in.setClient(this);
        });
    }

    public ClientDetails getClienteDetails() {
        return clienteDetails;
    }

    public void setClienteDetails(ClientDetails clienteDetails) {
        this.clienteDetails = clienteDetails;
        this.clienteDetails.setClient(this);
    }

    public void removeClienteDetails() {
        this.clienteDetails.setClient(null);
        
        this.clienteDetails = null;
    }




}
