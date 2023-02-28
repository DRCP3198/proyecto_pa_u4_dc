package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CiudadanoM;
import com.example.demo.modelo.Estudiante;
import com.example.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoPaU4DcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4DcApplication.class, args);
	}

	private static Logger LOG = LoggerFactory.getLogger(CiudadanoM.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<CiudadanoM> ciudadanoList = this.ciudadanoService.buscar();
		for (CiudadanoM ciudadano : ciudadanoList) {
			
			LOG.info("la lista es: "+ciudadano);
			//System.out.println(ciudadano);
			
		}
		System.out.println(ciudadanoList.size());
		
		Estudiante e =this.ciudadanoService.convertirEstudiante(ciudadanoList.get(0));
		LOG.info("Estudiante convertido " + e);
		
		this.ciudadanoService.procesarEstudianteParalelo();
		}
	

}
