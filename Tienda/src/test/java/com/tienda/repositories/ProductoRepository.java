
package com.tienda.repositories;

import com.tienda.entities.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Usuario
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    // ✅ Consulta amplia de productos con filtros opcionales
    @Query("SELECT p FROM Producto p WHERE " +
           "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:categoria IS NULL OR LOWER(p.categoria) LIKE LOWER(CONCAT('%', :categoria, '%'))) AND " +
           "(:precioMin IS NULL OR p.precio >= :precioMin) AND " +
           "(:precioMax IS NULL OR p.precio <= :precioMax)")
    List<Producto> buscarProductos(@Param("nombre") String nombre,
                                   @Param("categoria") String categoria,
                                   @Param("precioMin") Double precioMin,
                                   @Param("precioMax") Double precioMax);
}

