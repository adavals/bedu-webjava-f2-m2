package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Producto;
import org.bedu.postwork.javase2project.model.Subasta;
import org.bedu.postwork.javase2project.model.Usuario;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionParticipantes {
    public static void main(String[] args) {

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitud -> {
           System.out.println("Usuario: " + solicitud.getUsuario().getNombre()
                + " se inscribió en la subasta: " + solicitud.getSubasta().getProducto().getNombre());
        });

        Random random = new Random();

        eventLoop.iniciar();
        SolicitudParticipante[] solicitudes = crearSolicitudes();

        for (SolicitudParticipante s : solicitudes) {
            eventLoop.registrarEvento(s);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eventLoop.detener();
    }

    private static SolicitudParticipante[] crearSolicitudes() {
        Random random = new Random();
        Subasta[] subastas = new Subasta[4];
        subastas[0] = crearSubasta(1, "Caldero", random);
        subastas[1] = crearSubasta(2,  "Varita mágica", random);
        subastas[2] = crearSubasta(3, "Mapa del merodeador", random);
        subastas[3] = crearSubasta(4, "Capa de invisivilidad", random);

        SolicitudParticipante[] solicitudes = new SolicitudParticipante[20];
        for (int i = 0; i < 20; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuarioId((long)i);
            usuario.setNombre("Clon " + i);

            solicitudes[i] = new SolicitudParticipante(usuario, subastas[random.nextInt(subastas.length)]);
        }
        return solicitudes;
    }

    private static Subasta crearSubasta(long subastaId, String nombreProducto, Random random ) {
        Subasta subasta = new Subasta();
        subasta.setSubastaId(subastaId);

        Producto producto = new Producto();
        producto.setNombre(nombreProducto);
        subasta.setProducto(producto);

        return subasta;
    }
}
