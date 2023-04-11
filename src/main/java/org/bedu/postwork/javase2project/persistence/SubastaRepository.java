package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Subasta;
import org.springframework.data.repository.CrudRepository;

public interface SubastaRepository extends CrudRepository<Subasta,Long> {

    Subasta findFirstByOrderBySubastaId();
}
