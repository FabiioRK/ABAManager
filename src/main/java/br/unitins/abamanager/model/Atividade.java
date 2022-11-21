package br.unitins.abamanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String descricao;
	private Double nota;
	private String pacienteAvaliado;
	private String profissionalAplicador;
	private String dataAtividade;
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String getPacienteAvaliado() {
		return pacienteAvaliado;
	}
	public void setPacienteAvaliado(String pacienteAvaliado) {
		this.pacienteAvaliado = pacienteAvaliado;
	}
	public String getProfissionalAplicador() {
		return profissionalAplicador;
	}
	public void setProfissionalAplicador(String profissionalAplicador) {
		this.profissionalAplicador = profissionalAplicador;
	}
	public String getDataAtividade() {
		return dataAtividade;
	}
	public void setDataAtividade(String dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

}
