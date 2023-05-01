package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Postwork2 {

    public static void iniciaMultithreading() {
        Random rnd = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        Subasta[] subastas = new Subasta[]{
                crearSubasta(rnd, "Lanzallamas", 1),
                crearSubasta(rnd, "Atun Dolores", 2),
                crearSubasta(rnd, "Frijolitos", 3),
                crearSubasta(rnd, "Tsuru Tuneado", 4)
        };
        for(Subasta subasta : subastas){
            try{
                pool.execute(new CalculadoraGanadorSubasta(subasta));
            }catch(Exception e){
                System.out.println(e);
            }
        }
        pool.shutdown();
    }

    private static Subasta crearSubasta(Random rnd, String nombreProducto, long idSubasta) {
        Producto producto = new Producto();
        producto.setNombre(nombreProducto);

        Subasta subasta = new Subasta();
        subasta.setSubastaId(idSubasta);
        subasta.setProducto(producto);
        subasta.setPrecioInicial(rnd.nextDouble(10,50));
        subasta.setPujaMinima(rnd.nextDouble(1,50));
        subasta.setPujaMaxima(rnd.nextDouble(subasta.getPujaMinima(),150));

        Set<Puja> pujas = new HashSet<>();
        int i;
        for (i = 0; i < 20; i++)
        {
            Usuario usuario = new Usuario();
            usuario.setUsuarioId(rnd.nextLong(1,20));
            usuario.setNombre("Usuario: " + usuario.getUsuarioId());

            Puja puja = new Puja();
            puja.setPujaId((long) i);
            puja.setUsuario(usuario);
            puja.setCantidad(rnd.nextDouble(subasta.getPujaMinima(),subasta.getPujaMaxima()));
            puja.setFecha(LocalDateTime.now());

            pujas.add(puja);
        }
        subasta.setPujas(pujas);

        return subasta;
    }
}