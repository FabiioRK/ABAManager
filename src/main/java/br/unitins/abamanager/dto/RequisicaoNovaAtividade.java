package br.unitins.abamanager.dto;

import br.unitins.abamanager.model.Atividade;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovaAtividade {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;

	private Double nota;
	@NotBlank
	private String data;

	private String observacao;
	
	public Atividade toAtividade() {
		Atividade atividade = new Atividade();
		atividade.setTitulo(titulo);
		atividade.setDescricao(descricao);
		atividade.setNota(nota);
		atividade.setData(data);
		atividade.setObservacao(observacao);
		return atividade;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
