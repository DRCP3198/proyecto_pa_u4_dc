package com.example.demo.repo;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface IPersonaRepository {

	
	public List<Persona> buscarTodos();
	public Persona buscarPorId(Integer id);
	public void actualizar(Persona persona);
	public int eliminar(Integer id);
	public void guardar(Persona persona);
	
	
}
