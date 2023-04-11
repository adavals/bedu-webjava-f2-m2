package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Subasta;
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

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SubastaRepositoryTest {
    @Autowired
    private SubastaRepository subastaRepository;
    @BeforeAll
    void cleanDatabase(){
        /*subastaRepository.deleteAll()*/;
    }
    @Test
    @DisplayName("Guarda una subasta")
    void canSave(){
        Producto producto = new Producto();
        producto.setProductoId(1l);
        producto.setNombre("Funko Pop Appa - Avatar");
        producto.setDescripcion("Coleccion Avatar la leyenda de Ang");
        producto.setPrecio(250.00);

        Subasta subasta = new Subasta();
        subasta.setProducto(producto);

        subasta.setFechaInicial(LocalDateTime.parse("2023-05-05T10:00:00"));
        subasta.setFechaFinal(LocalDateTime.parse("2023-05-05T23:59:00"));
        subasta.setPrecioInicial(200.00);
        subasta.setPujaMinima(20.00);
        subasta.setPujaMaxima(50.00);
        subasta.setStatus("Por iniciar");

        subasta = subastaRepository.save(subasta);
        assertNotNull(subasta.getSubastaId());
    }
}