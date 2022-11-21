package br.unitins.abamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.unitins.abamanager.repository.ProfissionalRepository;

@Controller
public class IndexController {

	@Autowired
	private ProfissionalRepository profissionalRepo;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("profissionais", profissionalRepo.findAll());
		return "index";
	}
	
}
