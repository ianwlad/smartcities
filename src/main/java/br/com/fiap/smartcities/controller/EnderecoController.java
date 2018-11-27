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

import br.com.fiap.smartcities.dao.EnderecoDAO;
import br.com.fiap.smartcities.entity.Endereco;

@Controller
@RequestMapping("endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoDAO dao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")  int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/endereco/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("endereco/edicao").addObject("endereco", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Endereco endereco, RedirectAttributes attrs) {
		try {
		dao.atualizar(endereco);
		} catch (Exception e) {
			return new ModelAndView("endereco/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/endereco/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("endereco/lista").addObject("lista", dao.listar());
	}


	@GetMapping("cadastrar")
	public String abrirForm(Endereco endereco) {
		return "endereco/cadastro";
		}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Endereco endereco, RedirectAttributes redirect) {
		try {
			dao.cadastrar(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("endereco/cadastro");
		}
		redirect.addFlashAttribute("msg", "Endereco cadastrado!");
		return new ModelAndView("redirect:/endereco/cadastrar");
	}


}