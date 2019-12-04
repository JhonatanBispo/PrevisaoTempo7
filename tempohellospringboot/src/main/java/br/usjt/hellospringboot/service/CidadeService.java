package br.usjt.hellospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.hellospringboot.model.Cidade;
import br.usjt.hellospringboot.repository.CidadeRepository;


@Service

public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepo;
	
	public void salvar(Cidade cidade) {
		cidadeRepo.save(cidade);
	}
	
	public List<Cidade> listarTodos() {
		List<Cidade> cidades = cidadeRepo.findAll();
		return cidades;
	}
}
