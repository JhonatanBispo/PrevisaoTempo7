package br.usjt.hellospringboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Acesso;
import br.usjt.hellospringboot.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject(new Acesso());
		return mv;
	}

	@PostMapping ("/fazerLogin")
	public String fazerLogin (HttpServletRequest request,
			Acesso acesso) {
		if (loginService.logar(acesso)) {
			request.getSession().setAttribute("usuarioLogado",
					acesso);
			return "redirect:previsoes";
		} else {
			return "login";
		}
	}
}
