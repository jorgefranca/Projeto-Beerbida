package com.projeto.beerbida.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {
	
	@NotBlank //verifica se o campo é nulo (retira espaços)
	private String sku;
	private String nome;
	
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
