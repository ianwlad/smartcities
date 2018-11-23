package br.com.fiap.smartcities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.smartcities.dao.LojaDAO;
import br.com.fiap.smartcities.dao.ProdutoDAO;
import br.com.fiap.smartcities.entity.Loja;
import br.com.fiap.smartcities.entity.Produto;

@Controller
@RequestMapping("loja")
public class LojaController {
	
	@Autowired
	private LojaDAO dao;
	
	private List<Produto> produtos;
	
	@Autowired
	private ProdutoDAO pdao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")  int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/loja/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("loja/edicao").addObject("loja", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Loja loja, RedirectAttributes attrs) {
		try {
		dao.atualizar(loja);
		} catch (Exception e) {
			return new ModelAndView("loja/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/loja/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("loja/lista").addObject("lista", dao.listar());
	}


	@GetMapping("cadastrar")
	public String abrirForm(Loja loja) {
		return "loja/cadastro";
		}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Loja loja, RedirectAttributes redirect) {
		try {
			dao.cadastrar(loja);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("loja/cadastro");
		}
		redirect.addFlashAttribute("msg", "Loja cadastrada!");
		return new ModelAndView("redirect:/loja/cadastrar");
	}
	
	@PostMapping("addProduto")
	public void adicionarProduto(@RequestParam("idProduto") int produto) {
		produtos.add(pdao.buscar(produto));
	}


}