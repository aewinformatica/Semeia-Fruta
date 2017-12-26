package com.aewinformatica.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aewinformatica.projeto.model.Produtor;


public interface Produtores extends JpaRepository<Produtor, Long> {

	public Optional<Produtor> findByEmail(String email);

	public List<Produtor> findByCodigoIn(Long[] codigos);
}
