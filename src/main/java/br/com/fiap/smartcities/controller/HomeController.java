package br.com.fiap.smartcities.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "home/index";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "home/contato";
	}

}
