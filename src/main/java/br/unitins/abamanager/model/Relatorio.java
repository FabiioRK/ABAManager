package br.unitins.abamanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String relatorio;
	private String profissionalEmissor;
	private String pacienteReferenciado;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;

	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public String getProfissionalEmissor() {
		return profissionalEmissor;
	}

	public void setProfissionalEmissor(String profissionalEmissor) {
		this.profissionalEmissor = profissionalEmissor;
	}

	public String getPacienteReferenciado() {
		return pacienteReferenciado;
	}

	public void setPacienteReferenciado(String pacienteReferenciado) {
		this.pacienteReferenciado = pacienteReferenciado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
