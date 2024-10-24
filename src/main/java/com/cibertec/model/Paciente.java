package com.cibertec.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpaciente;
	private String nombre, direccion, telefono, correo,alergias, tratamientosprevios;
	
	@OneToOne
	@JoinColumn(name = "historial_medico_id", referencedColumnName = "idhistorial")
    private HistorialMedico historialMedico;
	
	@Override
	public String toString() 
	{
		return "Paciente [idpaciente="+idpaciente+", nombre="+nombre+", direccion="+direccion+", telefono="+telefono+", correo="+correo+", alergias="+alergias+", tratamientos previos="+tratamientosprevios+"]";
	}

	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getTratamientosprevios() {
		return tratamientosprevios;
	}

	public void setTratamientosprevios(String tratamientosprevios) {
		this.tratamientosprevios = tratamientosprevios;
	}

	public HistorialMedico getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(HistorialMedico historialMedico) {
		this.historialMedico = historialMedico;
	}
	
	
}
