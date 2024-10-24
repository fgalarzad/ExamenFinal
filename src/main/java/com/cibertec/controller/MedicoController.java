package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.model.Medico;
import com.cibertec.service.MedicoService;

@Controller
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;


    @GetMapping("/medicos/lista")
    public String listarMedicos(Model model) {
        List<Medico> medicos = medicoService.listarMedicos();
        model.addAttribute("medicos", medicos);
        return "lista-medicos";
    }
}

