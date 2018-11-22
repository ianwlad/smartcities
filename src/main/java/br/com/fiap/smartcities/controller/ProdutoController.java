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

import br.com.fiap.smartcities.dao.ProdutoDAO;
import br.com.fiap.smartcities.entity.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;

	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id") int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/produto/listar";
	}

	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("produto/edicao").addObject("produto", dao.buscar(codigo));
	}

	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Produto produto, RedirectAttributes attrs) {
		try {
			dao.atualizar(produto);
		} catch (Exception e) {
			return new ModelAndView("produto/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/produto/listar");
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("produto/lista").addObject("lista", dao.listar());
	}

	@GetMapping("cadastrar")
	public String abrirForm(Produto produto) {
		return "produto/cadastro";
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Produto produto, RedirectAttributes redirect) {
		try {
			dao.cadastrar(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("produto/cadastro");
		}
		redirect.addFlashAttribute("msg", "Produto cadastrado!");
		return new ModelAndView("redirect:/produto/cadastrar");
	}

}
