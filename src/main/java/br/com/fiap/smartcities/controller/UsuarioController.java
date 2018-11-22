package br.com.fiap.smartcities.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.smartcities.dao.UsuarioDAO;
import br.com.fiap.smartcities.entity.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	private UsuarioDAO dao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id") int id, RedirectAttributes redirect) {
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluido!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/usuario/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("usuario/edicao").addObject("produto", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(Usuario usuario, RedirectAttributes attrs) {
		try {
			dao.atualizar(usuario);
		} catch (Exception e) {
			return new ModelAndView("usuario/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado!");
		return new ModelAndView("redirect:/usuario/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("usuario/lista").addObject("lista", dao.listar());
	}
	
	@GetMapping("cadastrar")
	public String abrirForm(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Usuario usuario, RedirectAttributes redirect) {
		try {
			dao.cadastrar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("usuario/cadastro");
		}
		redirect.addFlashAttribute("msg", "Usuario cadastrado!");
		return new ModelAndView("redirect:/usuario/cadastrar");
	}
}
