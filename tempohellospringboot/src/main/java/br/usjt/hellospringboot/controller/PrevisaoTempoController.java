package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.PrevisaoTempo;
import br.usjt.hellospringboot.service.TempoService;

@Controller
public class PrevisaoTempoController {
	@Autowired
	private TempoService tempService;

	@GetMapping ("/tempos")
	public ModelAndView listarDados () {
		//passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("lista_tempos");
		//Busque a coleção com o repositório
		List <PrevisaoTempo> temp = tempService.listarTodos();
		//adicione a coleção ao objeto ModelAndView
		mv.addObject("tempos", temp);
		mv.addObject(new PrevisaoTempo());
		//devolva o ModelAndView
		return mv;
	}

	@PostMapping
	public String salvar (PrevisaoTempo temp) {
		tempService.salvar(temp);
		return "redirect:/previsoes";
	}
}





