package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Usuario findFirstByOrderByUsuarioId();
}
