package br.unitins.abamanager.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unitins.abamanager.model.Paciente;
import br.unitins.abamanager.repository.PacienteRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PacienteRepository pacienteRepo;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		List<Paciente> pacientes = pacienteRepo.findAllByUsuario(principal.getName());
		model.addAttribute("pacientes", pacientes);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
