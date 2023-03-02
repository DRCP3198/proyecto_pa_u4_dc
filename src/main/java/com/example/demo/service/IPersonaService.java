package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface IPersonaService {
	public List<Persona> encontrarTodos();
	public Persona encontrarPorId(Integer id);
	public void modificar(Persona persona);
	public void borrar(Integer id);
	public void agregar(Persona persona);
	
}
