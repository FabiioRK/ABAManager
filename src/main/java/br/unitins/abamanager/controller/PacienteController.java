package br.unitins.abamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("salvar")
	public String salvar(Paciente paciente) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		paciente.setUser(user);
		pacienteRepository.save(paciente);
		
		return "redirect:/home";
	}
	
    @DeleteMapping("remover/{id}")
    public String remover(@PathVariable("id")Long id) {
    	pacienteRepository.deleteById(id);
        return "redirect:/home";
    }
    
    @PutMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
    	Paciente paciente = this.pacienteRepository.findById(id).get();
    	model.addAttribute("paciente", paciente);
    	
    	return "paciente/editar-paciente";
    }

}
