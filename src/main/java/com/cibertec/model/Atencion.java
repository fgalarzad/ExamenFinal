package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Atenciones")
public class Atencion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAtencion;
    private String fechaAtencion,motivoConsulta, diagnosticoPreliminar, tratamientoSugerido,observaciones;

    @ManyToOne
    @JoinColumn(name = "medico_id" , referencedColumnName ="idMedicos")
    private Medico medicoAtiende;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName ="idpaciente")
    private Paciente paciente;
    
    @Override
	public String toString() 
	{
		return "Atencion [idAtencion="+idAtencion+", fecha de atencion="+fechaAtencion+", motivo de consulta="+motivoConsulta+", diagnostico preliminar="+diagnosticoPreliminar+", tratamiento sugerido="+tratamientoSugerido+", observaciones="+observaciones+"]";
	}

	public int getIdAtencion() {
		return idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getDiagnosticoPreliminar() {
		return diagnosticoPreliminar;
	}

	public void setDiagnosticoPreliminar(String diagnosticoPreliminar) {
		this.diagnosticoPreliminar = diagnosticoPreliminar;
	}

	public String getTratamientoSugerido() {
		return tratamientoSugerido;
	}

	public void setTratamientoSugerido(String tratamientoSugerido) {
		this.tratamientoSugerido = tratamientoSugerido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Medico getMedicoAtiende() {
		return medicoAtiende;
	}

	public void setMedicoAtiende(Medico medicoAtiende) {
		this.medicoAtiende = medicoAtiende;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
    
    
 
}
