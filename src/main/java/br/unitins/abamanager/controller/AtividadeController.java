package br.unitins.abamanager.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unitins.abamanager.dto.RequisicaoNovaAtividade;
import br.unitins.abamanager.model.Atividade;
import br.unitins.abamanager.model.Paciente;
import br.unitins.abamanager.repository.AtividadeRepository;
import br.unitins.abamanager.repository.PacienteRepository;
import br.unitins.abamanager.service.AtividadeReportService;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;

@Controller
public class AtividadeController {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private AtividadeReportService service;

	@GetMapping("atividades/formulario/{idPaciente}")
	public String formulario(@PathVariable("idPaciente") Long id, RequisicaoNovaAtividade requisicao, Model model) {
		Paciente paciente = pacienteRepository.findById(id).get();
		model.addAttribute("paciente", paciente);
		return "atividade/formulario";
	}

	@PostMapping("atividades/novo/{idPaciente}")
	public String novo(@PathVariable("idPaciente") Long id, @Valid RequisicaoNovaAtividade requisicaoNovaAtividade,
			BindingResult result, Model model, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			Paciente paciente = pacienteRepository.findById(id).get();
			model.addAttribute("paciente", paciente);
			return "atividade/formulario";
		}

		Paciente paciente = pacienteRepository.findById(id).get();
		Atividade atividade = requisicaoNovaAtividade.toAtividade();
		atividade.setPaciente(paciente);

		atividadeRepository.save(atividade);

		redirect.addFlashAttribute("message", "Atividade adicionada com sucesso");

		return "redirect:/atividades/{idPaciente}";
	}

	@PostMapping("atividades/salvar/{idPaciente}")
	public String salvar(@PathVariable("idPaciente") Long idPaciente, Atividade atividade,
			RedirectAttributes redirect) {
		Paciente paciente = pacienteRepository.findById(idPaciente).get();
		atividade.setPaciente(paciente);

		atividadeRepository.save(atividade);

		redirect.addFlashAttribute("message", "Atividade atualizada com sucesso");

		return "redirect:/atividades/{idPaciente}";
	}

	@RequestMapping("atividades/remover/{idPaciente}/{id}")
	public String remover(@PathVariable("idPaciente") Long idPaciente, @PathVariable("id") Long id, RedirectAttributes redirect) {
		atividadeRepository.deleteById(id);
		
		redirect.addFlashAttribute("delmessage", "Atividade removida com sucesso");
		
		return "redirect:/atividades/{idPaciente}";
	}

	@RequestMapping("atividades/editar/{idPaciente}/{id}")
	public String editar(@PathVariable("idPaciente") Long idPaciente, @PathVariable("id") Long id, Model model) {
		Atividade atividade = this.atividadeRepository.findById(id).get();
		Paciente paciente = pacienteRepository.findById(idPaciente).get();

		model.addAttribute("atividade", atividade);
		model.addAttribute("paciente", paciente);

		return "atividade/editar-atividade";
	}

	@GetMapping("atividades/report/{format}/{idPaciente}")
	public String gerarRelatorio(@PathVariable String format, @PathVariable("idPaciente") Long idPaciente,
			RedirectAttributes redirect) throws FileNotFoundException, JRException {
		return service.exportReport(format, idPaciente, redirect);
	}

}
