package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.modelo.CiudadanoM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CiudadanoRepoImpl implements ICiudadanoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CiudadanoM> consultar() {
		// TODO Auto-generated method stub

		Query query = this.entityManager.createNativeQuery("select * from ciudadano_p", CiudadanoM.class);
		
		return query.getResultList();
	}

	/*public List<CiudadanoM> consultar() {
		
		Query query = this.entityManager.createNativeQuery("select * from ciudadano_p", CiudadanoM.class);
		
		return query.getResultList();
	}*/

}
