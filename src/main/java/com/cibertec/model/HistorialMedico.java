package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="HistorialMedicos")
public class HistorialMedico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idhistorial;
	private String tratamientosrecibidos, fecha, diagnostico, radiografias;
	
	@ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "idMedicos")
    private Medico medico;
	
	@Override
	public String toString() 
	{
		return "Hitorial Medico [idhistorial="+idhistorial+", tratamientos recibidos="+tratamientosrecibidos+", fecha="+fecha+", diagnostico="+diagnostico+", radiografías="+radiografias+", medico="+medico+"]";
	}

	public int getIdhistorial() {
		return idhistorial;
	}

	public void setIdhistorial(int idhistorial) {
		this.idhistorial = idhistorial;
	}

	public String getTratamientosrecibidos() {
		return tratamientosrecibidos;
	}

	public void setTratamientosrecibidos(String tratamientosrecibidos) {
		this.tratamientosrecibidos = tratamientosrecibidos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getRadiografias() {
		return radiografias;
	}

	public void setRadiografias(String radiografias) {
		this.radiografias = radiografias;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
