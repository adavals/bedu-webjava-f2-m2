package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
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

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PujaRepositoryTest {
    @Autowired
    private PujaRepository pujaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SubastaRepository subastaRepository;

    @BeforeAll
    void cleanDatabase(){
        /*pujaRepository.deleteAll();*/
    }
    @Test
    @DisplayName("Guarda una puja")
    void canSave(){
        // Debe existir al menos un registro en la tabla usuario
        Usuario usuario = usuarioRepository.findFirstByOrderByUsuarioId();
        // Debe existir al menos un registro en la tabla subasta
        Subasta subasta = subastaRepository.findFirstByOrderBySubastaId();

        Puja puja = new Puja();
        puja.setFecha(LocalDateTime.parse("2023-04-08T18:22:00"));
        puja.setCantidad(30.00);
        puja.setUsuario(usuario);
        puja.setSubasta(subasta);

        puja = pujaRepository.save(puja);

        assertNotNull(puja.getPujaId());
    }
}