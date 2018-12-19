package com.aewinformatica.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aewinformatica.projeto.model.Usuario;
import com.aewinformatica.projeto.repository.Grupos;
import com.aewinformatica.projeto.service.CadastroUsuarioService;
import com.aewinformatica.projeto.service.exception.EmailUsuarioJaCadastradoException;
import com.aewinformatica.projeto.service.exception.SenhaObrigatoriaUsuarioException;



@Controller
@RequestMapping("/produtores")
public class ProdutoresController {


	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Grupos grupos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/produtor/CadastraProdutor");
		mv.addObject("grupos", grupos.findOne(2L));
		return mv;
	}

	@PostMapping({ "/novo", "{\\+d}" })
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario);
		}
		
		try {
			cadastroUsuarioService.salvar(usuario);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(usuario);
		} catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
		}
		
		attributes.addFlashAttribute("mensagem", "Você se cadastrou com sucesso");
		return new ModelAndView("redirect:/login");
	}
}
