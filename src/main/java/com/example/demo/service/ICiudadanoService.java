package com.example.demo.service;

import java.util.List;


import com.example.demo.modelo.CiudadanoM;
import com.example.demo.modelo.Estudiante;

public interface ICiudadanoService {
	
	public List<CiudadanoM> buscar();
	
	public Estudiante convertirEstudiante(CiudadanoM ciudadanoM);
	
	public void procesarEstudianteParalelo();

}
