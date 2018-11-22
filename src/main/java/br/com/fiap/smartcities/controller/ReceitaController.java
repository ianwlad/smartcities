package br.com.fiap.smartcities.controller;

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

import br.com.fiap.smartcities.dao.ReceitaDAO;
import br.com.fiap.smartcities.entity.Receita;

@Controller
@RequestMapping("receita")
public class ReceitaController {

	@Autowired
	private ReceitaDAO dao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")  int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/receita/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("receita/edicao").addObject("receita", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Receita receita, RedirectAttributes attrs) {
		try {
		dao.atualizar(receita);
		} catch (Exception e) {
			return new ModelAndView("receita/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/receita/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("receita/lista").addObject("lista", dao.listar());
	}


	@GetMapping("cadastrar")
	public String abrirForm(Receita receita) {
		return "receita/cadastro";
		}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Receita receita, RedirectAttributes redirect) {
		try {
			dao.cadastrar(receita);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("receita/cadastro");
		}
		redirect.addFlashAttribute("msg", "Receita cadastrada!");
		return new ModelAndView("redirect:/receita/cadastrar");
	}

	@PostMapping("addProduto")
	public void adicionarProduto(@RequestParam("idProduto") int produto) {
		System.out.println(produto);
	}

}
