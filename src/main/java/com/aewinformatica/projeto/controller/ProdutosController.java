package com.aewinformatica.projeto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aewinformatica.projeto.controller.page.PageWrapper;
import com.aewinformatica.projeto.model.Produto;
import com.aewinformatica.projeto.repository.Produtos;
import com.aewinformatica.projeto.repository.filter.ProdutoFilter;
import com.aewinformatica.projeto.service.CadastroProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private CadastroProdutoService cadastroProdutoService;
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView mv = new ModelAndView( "/produto/CadastroProduto");
		return mv;
	}
	
	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		cadastroProdutoService.salvar(produto);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/produtos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProdutoFilter produtoFilter, BindingResult result
			, @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("produto/PesquisaProdutos");
		
		PageWrapper<Produto> paginaWrapper = new PageWrapper<>(produtos.filtrar(produtoFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	@GetMapping("/remover")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@RequestParam("codigos[]") Long [] codigos) {
		
		produtos.findByCodigoIn(codigos).forEach(p -> produtos.delete(p.getCodigo()));
	}
}
