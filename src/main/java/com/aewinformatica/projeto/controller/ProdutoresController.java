package com.aewinformatica.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aewinformatica.projeto.model.Produtor;
import com.aewinformatica.projeto.repository.Grupos;
import com.aewinformatica.projeto.service.CadastroProdutorService;
import com.aewinformatica.projeto.service.exception.EmailUsuarioJaCadastradoException;
import com.aewinformatica.projeto.service.exception.SenhaObrigatoriaUsuarioException;



@Controller
@RequestMapping("/produtores")
public class ProdutoresController {

	@Autowired
	private CadastroProdutorService cadastroProdutorService;
	
	@Autowired
	private Grupos grupos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Produtor produtor) {
		ModelAndView mv = new ModelAndView("/produtor/CadastraProdutor");
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}
	
	
	@PostMapping({ "/novo", "{\\+d}" })
	public ModelAndView salvar(@Valid Produtor produtor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produtor);
		}
		
		try {
			cadastroProdutorService.salvar(produtor);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(produtor);
		} catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(produtor);
		}
		
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
		return new ModelAndView("redirect:/produtor/novo");
	}
}
