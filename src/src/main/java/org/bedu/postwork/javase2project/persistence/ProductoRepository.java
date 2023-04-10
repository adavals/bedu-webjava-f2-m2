package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository <Producto,Long> {
}
