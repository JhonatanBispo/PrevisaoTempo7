package br.usjt.hellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.hellospringboot.model.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
	public Acesso findOneByLoginAndSenha(String login, String senha);
}