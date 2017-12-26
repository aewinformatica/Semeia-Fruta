package com.aewinformatica.projeto.repository.helper.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aewinformatica.projeto.model.Produto;
import com.aewinformatica.projeto.repository.filter.ProdutoFilter;



public interface ProdutosQueries {

public Page<Produto> filtrar(ProdutoFilter filtro, Pageable pageable);
	
//	public List<ProdutoDTO> porSkuOuNome(String skuOuNome);
	
//	public ValorItensEstoque valorItensEstoque();
}
