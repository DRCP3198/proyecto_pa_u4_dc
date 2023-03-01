package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Persona;
import com.example.demo.repo.IPersonaRepository;

@Service
public class PersonaServiceImpl  implements  IPersonaService{

	@Autowired
	private IPersonaRepository iPersonaRepository;
	
	@Override
	public List<Persona> encontrarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.buscarTodos();
	}

	@Override
	public Persona encontrarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.buscarPorId(id);
	}

	@Override
	public void modificar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.actualizar(persona);
		
	}

	@Override
	public int borrar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.eliminar(id);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.guardar(persona);
	}

}
