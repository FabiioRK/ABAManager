package br.unitins.abamanager.dto;
import br.unitins.abamanager.model.Paciente;

public class RequisicaoNovoPaciente {

	private String nome;
	private String profissionalResponsavel;
	private String telefone;
	private String email;
	private String cpf;
	private String endereco;

	public Paciente toPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setProfissionalResponsavel(profissionalResponsavel);
		paciente.setTelefone(telefone);
		paciente.setEmail(email);
		paciente.setCpf(cpf);
		paciente.setEndereco(endereco);

		return paciente;
	}
	// GETTERS E SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissionalResponsavel() {
		return profissionalResponsavel;
	}

	public void setProfissionalResponsavel(String profissionalResponsavel) {
		this.profissionalResponsavel = profissionalResponsavel;
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

}
