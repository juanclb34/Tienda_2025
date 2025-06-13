/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Entity  /* Elementos como este se llama anotacion y esto es para agregar META DATOS son la descripcion de un dato */
@Table(name = "productos")  /*Tablas plural, clase singular*/
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* Id es un primaryKey, es autoincremental*/
    private Long id;
    @NotBlank
    private String nombre;
    @Min(value = 100, message = "El precio es obligatorio")
    @NotNull(message = "El precio no puede ser nulo")
    private Double precio;
    
    public Producto(){
        // Constructor vacio necesario para JPA
    }
    
    public Producto(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
