package com.merber.springboot.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<DetalleOrden> detalleOrdenes;

    public Orden() {
    }

    public Orden(Long id, LocalDate fechaCompra, Cliente cliente, List<DetalleOrden> detalleOrdenes) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.detalleOrdenes = detalleOrdenes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    public void setDetalleOrdenes(List<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    }
}