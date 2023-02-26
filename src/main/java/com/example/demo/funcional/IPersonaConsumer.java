package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaConsumer <T,R>{
	
	public void aceptar(T arg1, R arg2);

}
