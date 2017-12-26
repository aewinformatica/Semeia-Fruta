package com.aewinformatica.projeto.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aewinformatica.projeto.model.Produto;
import com.aewinformatica.projeto.repository.Produtos;
import com.aewinformatica.projeto.service.exception.ImpossivelExcluirEntidadeException;
import com.aewinformatica.projeto.storage.FotoStorage;

@Service
public class CadastroProdutoService {

	@Autowired
	private Produtos produtos;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@Transactional
	public void salvar(Produto produto){
		produtos.save(produto);
		
	}
	
	@Transactional
	public void excluir(Produto produto) {
		try {
			String foto = produto.getFoto();
			produtos.delete(produto);
			produtos.flush();
			fotoStorage.excluir(foto);
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar produto. Já foi usado em alguma venda.");
		}
	}
	
}
