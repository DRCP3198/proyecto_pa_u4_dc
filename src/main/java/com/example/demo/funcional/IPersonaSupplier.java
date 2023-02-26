package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
	
	public T getNombre();  //No recibe ningun argumento pero recibe un tipo de dato determinado

}
