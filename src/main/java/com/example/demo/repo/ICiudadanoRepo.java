package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.modelo.CiudadanoM;

@Repository
public interface ICiudadanoRepo {

	
	public List<CiudadanoM> consultar();
}
