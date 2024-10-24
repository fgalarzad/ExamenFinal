package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.model.HistorialMedico;
import com.cibertec.model.Paciente;
import com.cibertec.service.HistorialService;
import com.cibertec.service.PacienteService;

@Controller
public class PacienteController {
	
	@Autowired
    private PacienteService pacienteService;
	@Autowired
    private HistorialService historialService;
  
	@GetMapping("/registro-paciente")
	public String mostrarFormularioRegistro(Model model) {
	    Paciente paciente = new Paciente();
	    List<HistorialMedico> historialesMedicos = historialService.listarHistorial();  // Obtener lista de historiales
	    model.addAttribute("paciente", paciente);
	    model.addAttribute("historialesMedicos", historialesMedicos);  // Añadir la lista al modelo
	    return "registro-paciente";
	}


    @PostMapping("/pacientes/registrar")
    public String registrarPaciente(@ModelAttribute("paciente") Paciente paciente, @RequestParam("historialMedicoId") int historialMedicoId) throws Exception {
    	HistorialMedico historialMedico = historialService.obtenerHistorialPorId(historialMedicoId);
        paciente.setHistorialMedico(historialMedico);
    	pacienteService.addPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", pacientes);
        return "lista-pacientes";  
    }
}
