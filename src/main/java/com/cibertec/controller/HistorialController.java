package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.HistorialMedico;

import com.cibertec.model.Paciente;
import com.cibertec.service.HistorialService;
import com.cibertec.service.PacienteService;

@Controller
public class HistorialController {
    
	
	@Autowired
	private PacienteService pacienteService;
    @Autowired
    private HistorialService historialService;

    @GetMapping("/historiales/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        HistorialMedico historialMedico = new HistorialMedico();
        model.addAttribute("historialMedico", historialMedico);
        return "registro-historial-medico";
    }

    @PostMapping("/historiales/registrar")
    public String registrarHistorialMedico(@ModelAttribute("historialMedico") HistorialMedico historialMedico) throws Exception {
    	historialService.addHistorial(historialMedico);
        return "redirect:/historiales/lista";
    }

    @GetMapping("/historiales/lista")
    public String listarHistorialesMedicos(Model model) {
        List<HistorialMedico> historiales = historialService.listarHistorial();
        model.addAttribute("historiales", historiales);
        return "lista-historiales-medicos";
    }
    
    @GetMapping("/historiales/gestionar/{id}")
    public String gestionarHistorialPaciente(@PathVariable Integer id, Model model) {
        Optional<Paciente> paciente = pacienteService.obtenerPacientePorId(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            model.addAttribute("historialMedico", paciente.get().getHistorialMedico()); 
            return "historial-paciente";         
        } else {
            return "redirect:/pacientes"; 
        }
    }
    

    
}

