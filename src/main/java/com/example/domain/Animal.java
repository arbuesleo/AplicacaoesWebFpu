package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "tb_animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String identificacao;
	Boolean extinto;
	Character tipo; // M - Marinho T - Terreste
	String urlImagem;
	
	public Animal(Integer id, String identificacao, Boolean extinto, Character tipo, String urlImagem) {
		super();
		this.id = id;
		this.identificacao = identificacao;
		this.extinto = extinto;
		this.tipo = tipo;
		this.urlImagem = urlImagem;
	}	
	
	public Animal() {
		
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public Boolean getExtinto() {
		return extinto;
	}
	public void setExtinto(Boolean extinto) {
		this.extinto = extinto;
	}
	public Character getTipo() {
		return tipo;
	}
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
}
