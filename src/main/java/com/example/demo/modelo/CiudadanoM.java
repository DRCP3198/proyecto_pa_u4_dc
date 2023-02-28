package com.example.demo.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="ciudadano_p")
public class CiudadanoM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_ciud")
	@SequenceGenerator(sequenceName = "seq_ciud",name = "seq_ciud",allocationSize = 1)
	@Column(name = "ciud_id")
	private Integer id;
	
	@Column(name = "ciud_nombre")
	private String nombre;
	
	@Column(name = "ciud_apellido")
	private String apellido;
	
	@Column(name = "ciud_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@OneToOne(mappedBy = "ciudadanos")
	private Estudiante estudiantes;


	public Estudiante getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(Estudiante estudiantes) {
		this.estudiantes = estudiantes;
	}
	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", estudiantes=" + estudiantes + "]";
	}
	
	
	

}
