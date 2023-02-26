package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona> {

	
	
	
	
	@Override
	public Persona getNombre() {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setApellido("Coloma1");
		persona.setNombre("Dillan1");
		return persona;
	}
	
	

}
