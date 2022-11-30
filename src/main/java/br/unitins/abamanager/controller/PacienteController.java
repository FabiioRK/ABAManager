package br.unitins.abamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unitins.abamanager.dto.RequisicaoNovoPaciente;
import br.unitins.abamanager.model.Paciente;
import br.unitins.abamanager.model.User;
import br.unitins.abamanager.repository.PacienteRepository;
import br.unitins.abamanager.repository.UserRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPaciente requisicao) {
		return "paciente/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPaciente requisicaoNovoPaciente, BindingResult result) {
		if (result.hasErrors()) {
			return "paciente/formulario";
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);

		Paciente paciente = requisicaoNovoPaciente.toPaciente();
		paciente.setUser(user);
		pacienteRepository.save(paciente);

		return "redirect:/home";
	}

	@GetMapping("delete")
	public String deleteEmployee(@PathVariable("id") Long id) {
		System.out.println("CHEGOU AQUI");
		pacienteRepository.deleteById(id);
		return "redirect:/home";
	}

}
