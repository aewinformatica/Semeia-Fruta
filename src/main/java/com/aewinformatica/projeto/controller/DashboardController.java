package com.aewinformatica.projeto.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class DashboardController {

//	@Autowired
//	private Vendas vendas;
	
//	@Autowired
//	private Produtos produtos;
	
//	@Autowired
//	private Clientes clientes;
	
	@GetMapping("/")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("Dashboard");
		
//		mv.addObject("vendasNoAno", vendas.valorTotalNoAno());
//		mv.addObject("vendasNoMes", vendas.valorTotalNoMes());
//		mv.addObject("ticketMedio", vendas.valorTicketMedioNoAno());
		
//		mv.addObject("valorItensEstoque", produtos.valorItensEstoque());
//		mv.addObject("totalClientes", clientes.count());
		
		return mv;
	}
	
}
