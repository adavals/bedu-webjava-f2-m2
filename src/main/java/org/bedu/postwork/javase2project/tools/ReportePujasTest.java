package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.in;
import static org.assertj.core.api.Assertions.*;

class ReportePujasTest {

    private static final Producto PRODUCTO = new Producto();
    private static final Usuario USUARIO_1 = new Usuario();
    private static final Usuario USUARIO_2 = new Usuario();
    private static final Usuario USUARIO_3 = new Usuario();
    private static final Subasta SUBASTA = new Subasta();

    private static final Puja PUJA_1 = new Puja();
    private static final Puja PUJA_2 = new Puja();
    private static final Puja PUJA_3 = new Puja();


    private static ReportePujas.Reporte reporte1;
    private static ReportePujas.Reporte reporte2;
    private static ReportePujas.Reporte reporte3;

    static{
        PRODUCTO.setNombre("Producto Que Todos Quieren");

        USUARIO_1.setNombre("Grecia");
        USUARIO_2.setNombre("Capri");
        USUARIO_3.setNombre("Bono");

        SUBASTA.setPrecioInicial(100.0);
        SUBASTA.setProducto(PRODUCTO);

        Set<Puja> pujas = new HashSet<>();

        PUJA_1.setUsuario(USUARIO_1);
        PUJA_1.setCantidad(90.0);
        PUJA_2.setUsuario(USUARIO_2);
        PUJA_2.setCantidad(40.0);
        PUJA_3.setUsuario(USUARIO_3);
        PUJA_3.setCantidad(100.0);

        pujas.add(PUJA_1);
        pujas.add(PUJA_2);
        pujas.add(PUJA_3);

        SUBASTA.setPujas(pujas);

        reporte1 = new ReportePujas.Reporte("Grecia", 90.0);
        reporte2 = new ReportePujas.Reporte("Capri", 40.0);
        reporte3 = new ReportePujas.Reporte("Bono", 100.0);

    }

    @Test
    @DisplayName("Ordena alfabéticamente por usuario")
    void alfabetico(){
        ReportePujas reportePujas = new ReportePujas();

        assertThat(reportePujas.alfabetico(SUBASTA)).containsExactly(reporte3, reporte2, reporte1);
    }


    @Test
    @DisplayName("Ordena por cantidad de puja")
    void pujas(){
        ReportePujas reportePujas = new ReportePujas();

        assertThat(reportePujas.cantidadPuja(SUBASTA)).containsExactly(reporte3, reporte1, reporte2);
    }

}