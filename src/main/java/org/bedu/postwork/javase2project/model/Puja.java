package org.bedu.postwork.javase2project.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "puja")
public class Puja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "puja_id")
    private Long pujaId;

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "subasta_id")
    Subasta subasta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    private LocalDateTime fecha;

    private Double cantidad;

    public Long getPujaId() {
        return pujaId;
    }

    public void setPujaId(Long pujaId) {
        this.pujaId = pujaId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Puja puja)) return false;
        return Objects.equals(pujaId, puja.pujaId) && Objects.equals(fecha, puja.fecha) && Objects.equals(cantidad, puja.cantidad) && Objects.equals(usuario, puja.usuario) && Objects.equals(subasta, puja.subasta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pujaId, fecha, cantidad, usuario, subasta);
    }
}
