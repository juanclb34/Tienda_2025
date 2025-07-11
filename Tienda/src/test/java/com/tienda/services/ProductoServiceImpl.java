package com.tienda.services;

import com.tienda.entities.Producto;
import com.tienda.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> getById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Producto> delete(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.deleteById(id);
        }
        return producto;
    }

    @Override
    @Transactional
    public Optional<Producto> update(Long id, Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto prod = productoExistente.get();

            prod.setNombre(producto.getNombre());
            prod.setPrecio(producto.getPrecio());
            prod.setCategoria(producto.getCategoria());
            prod.setStock(producto.getStock());
            // Si tienes más campos en Producto, agrégalos aquí

            return Optional.of(productoRepository.save(producto));
        }
        return productoExistente;
    }

    // ✅ Búsqueda avanzada con múltiples filtros (consulta amplia)
    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductos(String nombre, String categoria, Double precioMin, Double precioMax) {
        return productoRepository.buscarProductos(nombre, categoria, precioMin, precioMax);
    }
}
