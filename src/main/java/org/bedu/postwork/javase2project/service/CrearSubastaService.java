package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CrearSubastaService {


    public static Subasta crearSubasta(Random rnd, String nombreProducto, long idSubasta) {
        Producto producto = new Producto();
        producto.setNombre(nombreProducto);

        Subasta subasta = new Subasta();
        subasta.setSubastaId(idSubasta);
        subasta.setProducto(producto);
        subasta.setPrecioInicial(rnd.nextDouble(10,50));
        subasta.setPujaMinima(rnd.nextDouble(1,50));
        subasta.setPujaMaxima(rnd.nextDouble(subasta.getPujaMinima(),150));

        Set<Puja> pujas = new HashSet<>();

        // Nombres semanticos y delimitacion con constantes
        final int LIMITE_DE_PUJAS = 20;
        int indiceDePuja;
        for (indiceDePuja = 0; indiceDePuja < LIMITE_DE_PUJAS; indiceDePuja++)
        {
            Usuario usuario = new Usuario();
            usuario.setUsuarioId(rnd.nextLong(1,20));
            usuario.setNombre("Usuario: " + usuario.getUsuarioId());

            Puja puja = new Puja();
            puja.setPujaId((long) indiceDePuja);
            puja.setUsuario(usuario);
            puja.setCantidad(rnd.nextDouble(subasta.getPujaMinima(),subasta.getPujaMaxima()));
            puja.setFecha(LocalDateTime.now());

            pujas.add(puja);
        }
        subasta.setPujas(pujas);

        return subasta;
    }
}
