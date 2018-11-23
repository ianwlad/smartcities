package br.com.fiap.smartcities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.smartcities.dao.CompraDAO;
import br.com.fiap.smartcities.dao.ReceitaDAO;
import br.com.fiap.smartcities.entity.Compra;

@Controller
@RequestMapping("compra")
public class CompraController {
	
	@Autowired
	private CompraDAO dao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")  int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/compra/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("compra/edicao").addObject("compra", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Compra compra, RedirectAttributes attrs) {
		try {
		dao.atualizar(compra);
		} catch (Exception e) {
			return new ModelAndView("compra/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/compra/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("compra/lista").addObject("lista", dao.listar());
	}


	@GetMapping("cadastrar")
	public String abrirForm(Compra compra) {
		return "compra/cadastro";
		}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Compra compra, RedirectAttributes redirect) {
		try {
			dao.cadastrar(compra);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("compra/cadastro");
		}
		redirect.addFlashAttribute("msg", "Compra cadastrado!");
		return new ModelAndView("redirect:/compra/cadastrar");
	}


}