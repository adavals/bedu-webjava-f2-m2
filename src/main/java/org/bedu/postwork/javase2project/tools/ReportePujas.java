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
        return generaLista(subasta.getPujas(), (r1, r2 )-> r1.getNombreUsuario().compareTo(r2.getNombreUsuario()));
    }

    public List<Reporte> cantidadPuja(Subasta subasta){
        return generaLista(subasta.getPujas(), (r1, r2 )-> r2.getCantidadPuja().compareTo(r1.getCantidadPuja()));
    }

    private List<Reporte> generaLista(Set<Puja> pujas, Comparator<Reporte> comparator){
        return pujas.stream()
                .map(e -> new Reporte(e.getUsuario().getNombre(), e.getCantidad()))
                .sorted(comparator)
                .collect(Collectors.toList());

    }

}
