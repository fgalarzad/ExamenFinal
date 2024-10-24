package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Atencion;
import com.cibertec.repository.AtencionRepository;


import jakarta.transaction.Transactional;

@Service
public class AtencionService {
	
	@Autowired
	private AtencionRepository atencionrepository;
	
	@Transactional
	public Atencion addAtencion(Atencion atencion)throws Exception{
		Atencion savePacientetoDB=this.atencionrepository.save(atencion);
		return savePacientetoDB;
	}
	public List<Atencion> listarAtenciones() {
        return atencionrepository.findAll();
    }
	

}
