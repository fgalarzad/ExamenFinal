package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.HistorialMedico;
import com.cibertec.repository.HistorialRepository;

@Service
public class HistorialService {
	
	@Autowired
	private HistorialRepository historialrepository;
	
	
	public HistorialMedico addHistorial(HistorialMedico historial){
		HistorialMedico saveHistorialtoDB=this.historialrepository.save(historial);
		return saveHistorialtoDB;
	}
	public List<HistorialMedico> listarHistorial() {
        return historialrepository.findAll();

     }
	public HistorialMedico obtenerHistorialPorId(int id) {
	    return historialrepository.findById(id).orElse(null);
	}
}
