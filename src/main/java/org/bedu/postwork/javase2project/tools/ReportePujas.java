package org.bedu.postwork.javase2project.tools;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bedu.postwork.javase2project.model.Puja;
import org.bedu.postwork.javase2project.model.Subasta;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReportePujas {
    @Data
    @RequiredArgsConstructor
    static class Reporte {
       private final String nombreUsuario;
       private final Double cantidadPuja;
    }

    public List<Reporte> alfabetico(Subasta subasta){
        return generaLista(subasta.getPujas(), (primerReporte, segundoReporte )-> primerReporte.getNombreUsuario().compareTo(segundoReporte.getNombreUsuario()));
    }

    public List<Reporte> cantidadPuja(Subasta subasta){
        return generaLista(subasta.getPujas(), (primerReporte, segundoReporte )-> segundoReporte.getCantidadPuja().compareTo(primerReporte.getCantidadPuja()));
    }

    private List<Reporte> generaLista(Set<Puja> pujas, Comparator<Reporte> comparator){
        return pujas.stream()
                .map(puja -> new Reporte(puja.getUsuario().getNombre(), puja.getCantidad()))
                .sorted(comparator)
                .collect(Collectors.toList());

    }

}
