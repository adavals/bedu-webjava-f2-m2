package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;

public class SolicitudParticipante {
    private Usuario usuario;
    private Subasta subasta;

    public SolicitudParticipante(Usuario usuario, Subasta subasta) {
        this.usuario = usuario;
        this.subasta = subasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
}
