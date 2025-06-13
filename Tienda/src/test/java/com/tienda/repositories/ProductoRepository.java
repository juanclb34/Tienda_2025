
package com.tienda.repositories;

import com.tienda.entities.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */

/*

Interface : (Tipo de clase que define metodos, pero no como se implementan)
Extends : Heredar (herencia)
Clase Generica :

*/

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    
}
