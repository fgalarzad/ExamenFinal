package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Medicos")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMedicos;
	private String nombre, especialidad, tipo;
	
	@Override
	public String toString() 
	{
		return "Medico [idMedico="+idMedicos+", nombre="+nombre+", especialidad="+especialidad+", tipo="+tipo+"]";
	}

	public int getIdMedicos() {
		return idMedicos;
	}

	public void setIdMedicos(int idMedicos) {
		this.idMedicos = idMedicos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
