package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Paciente;
import com.cibertec.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienterepository;
	
	@Transactional
	public Paciente addPaciente(Paciente paciente)throws Exception{
		Paciente savePacientetoDB=this.pacienterepository.save(paciente);
		return savePacientetoDB;
	}
	public List<Paciente> listarPacientes() {
        return pacienterepository.findAll();
    }
	public Optional<Paciente> obtenerPacientePorId(int id) {
	    return pacienterepository.findById(id);
	}
	public boolean pacienteExists(Integer id) {
        return pacienterepository.existsById(id);
    }

}
