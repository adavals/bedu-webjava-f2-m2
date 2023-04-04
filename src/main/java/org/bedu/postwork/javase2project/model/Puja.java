package org.bedu.postwork.javase2project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "puja")
public class Puja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "puja_id")
    private Long pujaId;

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
        return Objects.equals(pujaId, puja.pujaId) && Objects.equals(fecha, puja.fecha) && Objects.equals(cantidad, puja.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pujaId, fecha, cantidad);
    }
}
