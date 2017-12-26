package com.aewinformatica.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.aewinformatica.projeto.model.Grupo;
import com.aewinformatica.projeto.model.Produtor;
import com.aewinformatica.projeto.repository.Grupos;
import com.aewinformatica.projeto.repository.Produtores;
import com.aewinformatica.projeto.service.exception.EmailUsuarioJaCadastradoException;
import com.aewinformatica.projeto.service.exception.SenhaObrigatoriaUsuarioException;

@Service
public class CadastroProdutorService {

	@Autowired
	private Produtores produtores;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void salvar(Produtor produtor) {
		
		Optional<Produtor> produtorExistente = produtores.findByEmail(produtor.getEmail());
		if (produtorExistente.isPresent() && !produtorExistente.get().equals(produtor)) {
			throw new EmailUsuarioJaCadastradoException("E-mail já cadastrado");
		}
		
		if (produtor.isNovo() && StringUtils.isEmpty(produtor.getSenha())) {
			throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
		}
		
		if (produtor.isNovo() || !StringUtils.isEmpty(produtor.getSenha())) {
			produtor.setSenha(this.passwordEncoder.encode(produtor.getSenha()));
		} else if (StringUtils.isEmpty(produtor.getSenha())) {
			produtor.setSenha(produtorExistente.get().getSenha());
		}
		produtor.setConfirmacaoSenha(produtor.getSenha());
		
		if (!produtor.isNovo() && produtor.getAtivo() == null) {
			produtor.setAtivo(produtorExistente.get().getAtivo());
		}
		
	     
        produtor.setGrupos(produtor.getGrupos());
		produtor.setAtivo(true);
		produtores.save(produtor);
	}

//	@Transactional
//	public void alterarStatus(Long[] codigos, StatusUsuario statusUsuario) {
//		statusUsuario.executar(codigos, produtores);
//	}
}
