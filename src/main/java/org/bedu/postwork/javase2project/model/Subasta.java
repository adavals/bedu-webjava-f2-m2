package org.bedu.postwork.javase2project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subasta")
public class Subasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subasta_id")
    private Long subastaId;

    private LocalDateTime fechaInicial;

    private LocalDateTime fechaFinal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
    private Producto producto;
    private Double precioInicial;
    private Double precioFinal;

    private String status;
    private Double pujaMinima;
    private Double pujaMaxima;

    @OneToMany(mappedBy = "subasta")
    private Set<Puja> pujas = new HashSet<>();



}
