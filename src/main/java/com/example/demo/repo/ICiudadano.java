package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;

@Repository
public interface ICiudadano {

	
	public void agregar(Ciudadano ciudadano);
}
