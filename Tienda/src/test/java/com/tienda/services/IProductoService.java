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
    public Producto save (Producto producto);
    public Optional <Producto> getById (Long Id);
    public Optional <Producto> delete (Long Id);
    public Optional <Producto> update (Long Id,Producto producto);
    
}
