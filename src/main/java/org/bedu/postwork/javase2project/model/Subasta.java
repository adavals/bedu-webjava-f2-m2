package org.bedu.postwork.javase2project.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
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
    private Set<Puja> pujas;

    public Long getSubastaId() {
        return subastaId;
    }

    public void setSubastaId(Long subastaId) {
        this.subastaId = subastaId;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(Double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPujaMinima() {
        return pujaMinima;
    }

    public void setPujaMinima(Double pujaMinima) {
        this.pujaMinima = pujaMinima;
    }

    public Double getPujaMaxima() {
        return pujaMaxima;
    }

    public void setPujaMaxima(Double pujaMaxima) {
        this.pujaMaxima = pujaMaxima;
    }

    public Set<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(Set<Puja> pujas) {
        this.pujas = pujas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subasta subasta)) return false;
        return Objects.equals(subastaId, subasta.subastaId) && Objects.equals(fechaInicial, subasta.fechaInicial) && Objects.equals(fechaFinal, subasta.fechaFinal) && Objects.equals(producto, subasta.producto) && Objects.equals(precioInicial, subasta.precioInicial) && Objects.equals(precioFinal, subasta.precioFinal) && Objects.equals(status, subasta.status) && Objects.equals(pujaMinima, subasta.pujaMinima) && Objects.equals(pujaMaxima, subasta.pujaMaxima) && Objects.equals(pujas, subasta.pujas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subastaId, fechaInicial, fechaFinal, producto, precioInicial, precioFinal, status, pujaMinima, pujaMaxima, pujas);
    }
}
