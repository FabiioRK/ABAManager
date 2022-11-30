package br.unitins.abamanager.dto;

import br.unitins.abamanager.model.Paciente;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoPaciente {

	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	@NotBlank
	private String endereco;

	private String observacao;
	
	public Paciente toPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setCpf(cpf);
		paciente.setEndereco(endereco);
		paciente.setObservacao(observacao);
		return paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
