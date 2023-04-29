package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;

public class CalculadoraGanadorSubasta implements Runnable {
    private final Subasta subasta;
    public CalculadoraGanadorSubasta(Subasta subasta)
    {
        this.subasta = subasta;
    }

    @Override
    public void run() {
        Double precioFinal = subasta.getPrecioInicial();
        String ganador = "";

        for(Puja i : subasta.getPujas()) {
            precioFinal += i.getCantidad();
            ganador = i.getUsuario().getNombre();
        }

        System.out.printf("\n Subasta: " + subasta.getSubastaId() + " " + subasta.getProducto().getNombre()
                         +"\n Ganador: " + ganador
                         +"\n Precio final: $%.2f "
                         +"\n --------------------------", precioFinal);
    }
}
