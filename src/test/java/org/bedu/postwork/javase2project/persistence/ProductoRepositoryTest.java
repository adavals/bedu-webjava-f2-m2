package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Producto;
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
class ProductoRepositoryTest {
    @Autowired
    private ProductoRepository productoRepository;
    @BeforeAll
    void cleanDatabase(){
        /*productoRepository.deleteAll()*/;
    }
    @Test
    @DisplayName("Guarda un producto")
    void canSave(){
        Producto producto = new Producto();
        producto.setNombre("Funko Pop Appa - Avatar");
        producto.setDescripcion("Coleccion Avatar la leyenda de Ang");
        producto.setPrecio(250.00);

        producto = productoRepository.save(producto);

        assertNotNull(producto.getProductoId());
    }
}