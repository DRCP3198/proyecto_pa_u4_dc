package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@Controller
@RequestMapping("/personas")
//como regla general siempre se debe poner el recurso general en plural
//Manejo un recurso Persona
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	//Vamos a programar para que ingrese una persona
	//Le vamos a decir cual es la siguiente parte de mi URL y cual es el verbo que lo va a atender
	//Es importante poner como parametro del metodo el modelo con el que va a trabajar
	@GetMapping("/nuevaPersona")
	public String paginaNuevaPersona(Persona persona) {
		
		//nombre de la vista que quiero que me devuelva al cliente
		return "vistaNuevaPersona";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		this.iPersonaService.agregar(persona);
		return "guardado";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Persona> lista= this.iPersonaService.encontrarTodos();
		modelo.addAttribute("personas", lista);
		return "vistaListaPersonas";
	}
	@DeleteMapping("/borrar/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		 this.iPersonaService.borrar(id);
		
		return "redirect:/personas/buscar";
	}
	
	@GetMapping("/buscarPorId/{id}")
	public String buscaPorId(@PathVariable("id") Integer id, Model  modelo) {
		Persona persona = this.iPersonaService.encontrarPorId(id);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
		
	}
	@PutMapping("/actualizar/{id}")
	public String actualizarPorId(@PathVariable("id") Integer id,Persona persona) {
		persona.setId(id);
		this.iPersonaService.modificar(persona);
		return "redirect:/personas/buscar";
	}
	

}
