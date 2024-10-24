package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Medico;
import com.cibertec.repository.MedicoRepository;



@Service
public class MedicoService {
	@Autowired
	private MedicoRepository medicorepository;
	
	public List<Medico> listarMedicos() {
        return medicorepository.findAll();
    }
	public Medico obtenerMedicoPorId(int id) {
	    return medicorepository.findById(id).orElse(null);
	}
}
