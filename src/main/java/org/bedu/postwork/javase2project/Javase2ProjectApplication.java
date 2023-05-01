package org.bedu.postwork.javase2project;

import org.bedu.postwork.javase2project.model.Usuario;
import org.bedu.postwork.javase2project.multithreading.Postwork2;
import org.bedu.postwork.javase2project.persistence.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Javase2ProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(Javase2ProjectApplication.class);
	public static void main(String[] args) {
		Postwork2.iniciaMultithreading();
		SpringApplication.run(Javase2ProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(UsuarioRepository usuarioRepository){
		return args -> {
		/*	Usuario usuario = new Usuario();
			usuario.setNombre("Bono");
			usuario.setRol("subastador");
			usuario.setContrasena("chaparro");
			usuarioRepository.save(usuario);
			log.info("-- Usuario creado");*/
            log.info("CommandLineRunner");
		};
	}

}
