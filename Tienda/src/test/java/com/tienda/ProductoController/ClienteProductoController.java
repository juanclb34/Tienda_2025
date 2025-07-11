package com.tienda.ProductoController;

import com.tienda.entities.Producto;
import com.tienda.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente/productos")
public class ClienteProductoController {

    @Autowired
    private ProductoService productoService;

    // Muestra la vista del catálogo cliente
    @GetMapping
    public String mostrarVista() {
        return "cliente-productos"; // Archivo HTML o JSP con la tabla y filtros
    }

    // Endpoint para búsqueda filtrada desde el cliente (ej: AJAX/fetch)
    @GetMapping("/buscar")
    @ResponseBody
    public List<Producto> buscarProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) Double precioMin,
            @RequestParam(required = false) Double precioMax) {
        return productoService.buscarProductos(nombre, categoria, precioMin, precioMax);
    }
}
