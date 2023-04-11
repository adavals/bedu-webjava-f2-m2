package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @BeforeAll
    void cleanDatabase(){
        /*usuarioRepository.deleteAll();*/
    }
    @Test
    @DisplayName("Guarda un usuario")
    void canSave(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Bono");
        usuario.setRol("subastador");
        usuario.setContrasena("chaparro");

        usuario = usuarioRepository.save(usuario);

        assertNotNull(usuario.getUsuarioId());
    }
}