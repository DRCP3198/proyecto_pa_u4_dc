package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaPredicate <T>{
	
	public Boolean evaluar(T arg);

}
