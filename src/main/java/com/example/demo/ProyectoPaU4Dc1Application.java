package com.example.demo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class ProyectoPaU4Dc1Application implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoPaU4Dc1Application.class);
	@Autowired
	private IPersonaService iPersonaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setNombre("Amely");
		persona.setApellido("Coloma");
		persona.setGenero("F");
		persona.setCedula("1751457191");
		
		//this.iPersonaService.guardar(persona);
//		
//		Persona per = this.iPersonaService.encontrarPorId(2);
//		LOG.info("La persona buscada es:" + per);
//		
//		
//		List<Persona> listaPersonas= this.iPersonaService.encontrarTodos();
//		listaPersonas.stream().forEach(persona1 -> System.out.println(persona1));
//		
//		this.iPersonaService.borrar(2);
	}

}
