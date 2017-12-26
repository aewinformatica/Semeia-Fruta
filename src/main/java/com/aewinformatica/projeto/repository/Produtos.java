package com.aewinformatica.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aewinformatica.projeto.model.Produto;
import com.aewinformatica.projeto.repository.helper.produto.ProdutosQueries;

@Repository
public interface Produtos extends JpaRepository<Produto, Long>,ProdutosQueries {

}
