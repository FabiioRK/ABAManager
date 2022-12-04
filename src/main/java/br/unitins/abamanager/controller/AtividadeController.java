package br.unitins.abamanager.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unitins.abamanager.dto.RequisicaoNovaAtividade;
import br.unitins.abamanager.model.Atividade;
import br.unitins.abamanager.model.Paciente;
import br.unitins.abamanager.repository.AtividadeRepository;
import jakarta.validation.Valid;

@Controller
public class AtividadeController {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@GetMapping("atividades/formulario")
	public String formulario(Paciente paciente, RequisicaoNovaAtividade requisicao) {
		return "atividade/formulario";
	}

	@PostMapping("atividades/novo")
	public String novo(@Valid RequisicaoNovaAtividade requisicaoNovaAtividade, BindingResult result) {
		if (result.hasErrors()) {
			return "atividade/formulario";
		}

		Atividade atividade = requisicaoNovaAtividade.toAtividade();
//		atividade.setPaciente(paciente);
		atividadeRepository.save(atividade);

		return "redirect:/home";
	}
	
	@PostMapping("atividades/salvar")
	public String salvar(Atividade atividade) {
		atividadeRepository.save(atividade);
		
		return "redirect:/home";
	}
	
    @RequestMapping("atividades/remover/{id}")
    public String remover(@PathVariable("id")Long id) {
    	atividadeRepository.deleteById(id);
        return "redirect:/home";
    }
    
    @RequestMapping("atividades/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
    	Atividade atividade = this.atividadeRepository.findById(id).get();
    	model.addAttribute("atividade", atividade);
    	
    	return "atividade/editar-atividade";
    }
    
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
