package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.modelo.CiudadanoM;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repo.ICiudadanoRepo;
import com.example.demo.repo.IEstudianteRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;

	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public List<CiudadanoM> buscar() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepo.consultar();
	}

	@Override
	public Estudiante convertirEstudiante(CiudadanoM ciudadanoM) {

		Estudiante estudiante = new Estudiante();
		estudiante.setEdad(25);
		estudiante.setNombreCompleto(ciudadanoM.getNombre() + ciudadanoM.getApellido());
		Integer edad = LocalDateTime.now().getYear() - ciudadanoM.getFechaNacimiento().getYear();
		this.estudianteRepo.insertar(estudiante);
		return estudiante;
	}

	@Override
	public void procesarEstudianteParalelo() {
		long tiempoInicial = System.currentTimeMillis();
		List<CiudadanoM> lis = buscar();

		List<Estudiante> listaEstu = lis.parallelStream().map(ciud -> convertirEstudiante(ciud)).collect(Collectors.toList());
		System.out.println(listaEstu + "hilo " + Thread.currentThread().getName());

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en segundos: " + tiempoTranscurrido);

	}

}
