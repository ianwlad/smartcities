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

import br.com.fiap.smartcities.dao.EstacionamentoDAO;
import br.com.fiap.smartcities.entity.Estacionamento;

@Controller
@RequestMapping("estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoDAO dao;
	
	@Transactional
	//@PostMapping("excluir")
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")  int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/estacionamento/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("estacionamento/edicao").addObject("estacionamento", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Estacionamento estacionamento, RedirectAttributes attrs) {
		try {
		dao.atualizar(estacionamento);
		} catch (Exception e) {
			return new ModelAndView("estacionamento/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/estacionamento/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("estacionamento/lista").addObject("lista", dao.listar());
	}


	@GetMapping("cadastrar")
	public String abrirForm(Estacionamento estacionamento) {
		return "estacionamento/cadastro";
		}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Estacionamento estacionamento, RedirectAttributes redirect) {
	  try {
		dao.cadastrar(estacionamento);
	  }catch(Exception e) {
		  e.printStackTrace();
	    return new ModelAndView("estacionamento/cadastro");
	  }
	  redirect.addFlashAttribute("msg", "Estacionamento cadastrado!");
	  return new ModelAndView("redirect:/estacionamento/cadastrar");	  
	}


}