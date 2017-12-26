package com.aewinformatica.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banco_especie")
public class BancoEspecie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo;
	
	Long descricao;
	
	Usuario proprietario;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getDescricao() {
		return descricao;
	}
	public void setDescricao(Long descricao) {
		this.descricao = descricao;
	}
	public Usuario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BancoEspecie other = (BancoEspecie) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
