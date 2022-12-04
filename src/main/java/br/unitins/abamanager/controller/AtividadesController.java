package br.unitins.abamanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unitins.abamanager.model.Atividade;
import br.unitins.abamanager.repository.AtividadeRepository;

@Controller
@RequestMapping("/atividades/{idPaciente}")
public class AtividadesController {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping
	public String atividade(Model model, @PathVariable("idPaciente") Long id) {
		Sort sort = Sort.by("id").descending();
		List<Atividade> atividades = atividadeRepository.findAllByPaciente(id, sort);
		model.addAttribute("atividades", atividades);
		return "atividades";
	}	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/atividades/{id}";
	}
	
	
}
