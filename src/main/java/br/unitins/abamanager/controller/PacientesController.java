package br.unitins.abamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unitins.abamanager.repository.PacienteRepository;

@Controller
public class PacientesController {

	@Autowired
	private PacienteRepository pacienteRepo;
	
	@GetMapping("paciente")
	public String pacientes(Model model) {
		model.addAttribute("pacientes", pacienteRepo.findAll());
		return "paciente";
	}
	
	
}
