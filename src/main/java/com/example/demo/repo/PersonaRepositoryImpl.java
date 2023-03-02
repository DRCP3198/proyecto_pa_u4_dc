package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Persona e");
		
		return query.getResultList();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}
	
	

}
