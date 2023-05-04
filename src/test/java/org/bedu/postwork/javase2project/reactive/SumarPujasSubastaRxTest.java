package org.bedu.postwork.javase2project.reactive;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// Evitar importar bibliotecas usando wildcards
//import java.util.*;
//import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SumarPujasSubastaRxTest {

    private static final Subasta SUBASTA = new Subasta();

    static {
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Bono");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Capri");

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Greñas");

        Producto producto = new Producto();
        producto.setNombre("Frisbee para perros");

        SUBASTA.setPrecioInicial(150.0);
        SUBASTA.setProducto(producto);

        Puja puja1 = new Puja();
        puja1.setUsuario(usuario1);
        puja1.setCantidad(25.0);

        Puja puja2 = new Puja();
        puja2.setUsuario(usuario2);
        puja2.setCantidad(15.0);

        Puja puja3 = new Puja();
        puja3.setUsuario(usuario3);
        puja3.setCantidad(50.0);

        Set<Puja> pujas = new HashSet<>();
        pujas.add(puja1);
        pujas.add(puja2);
        pujas.add(puja3);
        SUBASTA.setPujas(pujas);
    }

    @Test
    @DisplayName("Obtiene suma de pujas")
    void obtenerSuma(){
       SumarPujasSubastaRx sumarPujasSubastaRx = new SumarPujasSubastaRx();

       sumarPujasSubastaRx.obtenerSuma(SUBASTA)
                .subscribe(v -> assertThat(v).isEqualTo(90.0));
    }
}