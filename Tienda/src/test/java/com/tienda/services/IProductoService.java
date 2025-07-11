/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;

import com.tienda.entities.Producto;
import java.util.Optional;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IProductoService {

    public List<Producto> findAll();
    
    public Producto save(Producto producto);
    
    public Optional<Producto> getById(Long id);
    
    public Optional<Producto> delete(Long id);
    
    public Optional<Producto> update(Long id, Producto producto);

    // ✅ Método agregado para búsqueda avanzada de productos
    public List<Producto> buscarProductos(String nombre, String categoria, Double precioMin, Double precioMax);
}
