package org.bedu.postwork.javase2project.reactive;

import org.bedu.postwork.javase2project.model.Subasta;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Component
public class SumarPujasSubastaRx {

    public Mono<Double> obtenerSuma(Subasta subasta){

        return Flux.fromStream(subasta.getPujas().parallelStream())
        .collect(Collectors.summingDouble(i -> i.getCantidad()));

    }

}
