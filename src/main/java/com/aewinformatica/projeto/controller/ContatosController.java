package com.aewinformatica.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("contatos")
public class ContatosController {

	@GetMapping()
	public ModelAndView listar(){
		
		ModelAndView mv = new ModelAndView("/contato/Contatos");
		
		
		
		return mv;
		
	}
}
