package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.model.Atencion;
import com.cibertec.model.Medico;
import com.cibertec.service.AtencionService;
import com.cibertec.service.MedicoService;
import com.cibertec.service.PacienteService;

@Controller
public class AtencionController {
	@Autowired
    private MedicoService medicoService;
	@Autowired
    private PacienteService pacienteService;
    @Autowired
    private AtencionService atencionService;

    @GetMapping("/atenciones/añadir")
    public String mostrarFormularioRegistro(Model model) {
        Atencion atencion = new Atencion();
        List<Medico> medicos = medicoService.listarMedicos();
        model.addAttribute("atencion", atencion);
   
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        model.addAttribute("medicos", medicos);
        
        return "registro-atencion";
    }


    @PostMapping("/atenciones/registrar")
    public String registrarAtencion(@ModelAttribute("atencion") Atencion atencion, @RequestParam("medicoId") int medicoId) throws Exception {
    	Medico medicoExistente = medicoService.obtenerMedicoPorId(medicoId); 
        atencion.setMedicoAtiende(medicoExistente);
    	atencionService.addAtencion(atencion);
        return "redirect:/atenciones/lista";
        
    }

    @GetMapping("/atenciones/lista")
    public String listarAtenciones(Model model) {
        List<Atencion> atenciones = atencionService.listarAtenciones();
        model.addAttribute("atenciones", atenciones);
        return "lista-atenciones";
    }
}
