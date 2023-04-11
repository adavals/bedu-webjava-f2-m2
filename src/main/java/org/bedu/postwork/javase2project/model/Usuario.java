package org.bedu.postwork.javase2project.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nombre;

    private String rol;

    private String contrasena;
    /*@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)*/
    @OneToMany(mappedBy = "usuario")
    /*@JoinColumn(name = "usuario_id")*/
    private Set<Puja> pujas;

    /*private Set<Puja> pujas = new HashSet<>();*/


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(usuarioId, usuario.usuarioId) && Objects.equals(nombre, usuario.nombre) && Objects.equals(rol, usuario.rol) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(pujas, usuario.pujas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, nombre, rol, contrasena, pujas);
    }
}
