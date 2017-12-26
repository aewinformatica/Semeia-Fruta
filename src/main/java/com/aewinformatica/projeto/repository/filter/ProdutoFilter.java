package com.aewinformatica.projeto.repository.filter;

import java.math.BigDecimal;

public class ProdutoFilter {
	
	private String nome;
	private BigDecimal valorDe;
	private BigDecimal valorAte;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorDe() {
		return valorDe;
	}
	public void setValorDe(BigDecimal valorDe) {
		this.valorDe = valorDe;
	}
	public BigDecimal getValorAte() {
		return valorAte;
	}
	public void setValorAte(BigDecimal valorAte) {
		this.valorAte = valorAte;
	}
	

}
