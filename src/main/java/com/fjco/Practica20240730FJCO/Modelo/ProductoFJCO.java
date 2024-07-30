package com.fjco.Practica20240730FJCO.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "productos")
public class ProductoFJCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombreFJCO;

    @NotBlank(message = "La descripción es requerida")
    private String descripcionFJCO;

    @NotNull(message = "El precio es requerido")
    private Double precioFJCO;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimientoFJCO;

    @NotNull(message = "El estatus es requerido")
    private Byte estatusFJCO;

    @NotNull(message = "La existencia es requerida")
    private Integer existencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombreFJCO() {
        return nombreFJCO;
    }

    public void setNombreFJCO(@NotBlank(message = "El nombre es requerido") String nombreFJCO) {
        this.nombreFJCO = nombreFJCO;
    }

    public @NotBlank(message = "La descripción es requerida") String getDescripcionFJCO() {
        return descripcionFJCO;
    }

    public void setDescripcionFJCO(@NotBlank(message = "La descripción es requerida") String descripcionFJCO) {
        this.descripcionFJCO = descripcionFJCO;
    }

    public @NotNull(message = "El precio es requerido") Double getPrecioFJCO() {
        return precioFJCO;
    }

    public void setPrecioFJCO(@NotNull(message = "El precio es requerido") Double precioFJCO) {
        this.precioFJCO = precioFJCO;
    }

    public @NotNull(message = "La fecha de vencimiento es requerida") Date getFechaVencimientoFJCO() {
        return fechaVencimientoFJCO;
    }

    public void setFechaVencimientoFJCO(@NotNull(message = "La fecha de vencimiento es requerida") Date fechaVencimientoFJCO) {
        this.fechaVencimientoFJCO = fechaVencimientoFJCO;
    }

    public @NotNull(message = "El estatus es requerido") Byte getEstatusFJCO() {
        return estatusFJCO;
    }

    public void setEstatusFJCO(@NotNull(message = "El estatus es requerido") Byte estatusFJCO) {
        this.estatusFJCO = estatusFJCO;
    }

    public @NotNull(message = "La existencia es requerida") Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(@NotNull(message = "La existencia es requerida") Integer existencia) {
        this.existencia = existencia;
    }
}