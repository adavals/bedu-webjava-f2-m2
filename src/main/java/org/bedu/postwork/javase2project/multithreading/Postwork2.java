package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.service.CrearSubastaService;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Postwork2 {

    public static void iniciaMultithreading() {

        Random rnd = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        Subasta[] subastas = new Subasta[]{
                CrearSubastaService.crearSubasta(rnd, "Lanzallamas", 1),
                CrearSubastaService.crearSubasta(rnd, "Atun Dolores", 2),
                CrearSubastaService.crearSubasta(rnd, "Frijolitos", 3),
                CrearSubastaService.crearSubasta(rnd, "Tsuru Tuneado", 4)
        };
        for(Subasta subasta : subastas){
            try{
                pool.execute(new CalculadoraGanadorSubasta(subasta));
            }catch(Exception error){
                System.out.println(error);
            }
        }
        pool.shutdown();
    }


}