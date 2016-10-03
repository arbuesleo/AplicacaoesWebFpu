package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	String partido;
	Integer numero;
	String pathImagem;
	Float votos = 0.00000000f;
	
	public Candidato(Integer id, String nome, String partido, Integer numero, String pathImagem, Float votos) {
		super();
		this.id = id;
		this.nome = nome;
		this.partido = partido;
		this.numero = numero;
		this.pathImagem = pathImagem;
		this.votos = votos;
	}
	
	public Candidato() {
	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getPathImagem() {
		return pathImagem;
	}
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public Float getVotos() {
		return votos;
	}

	public void setVotos(Float votos) {
		this.votos = votos;
	}
	
	public void addVoto(){
		this.votos = this.votos + 1.0000000001f;
	}
}
