package br.usjt.hellospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.hellospringboot.model.Acesso;
import br.usjt.hellospringboot.repository.AcessoRepository;

@Service
public class LoginService {
	@Autowired
	AcessoRepository usuarioRepo;
	
	public boolean logar(Acesso acesso) {
		return usuarioRepo.findOneByLoginAndSenha(acesso.getLogin(),
				acesso.getSenha()) != null;
	}
}