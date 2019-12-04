package br.usjt.hellospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.hellospringboot.model.PrevisaoTempo;
// import br.usjt.hellospringboot.model.Calculadora;
import br.usjt.hellospringboot.repository.PrevisaoTempoRepository;


@Service
public class TempoService {
	@Autowired
	private PrevisaoTempoRepository previsaoRepo;
	

	
	public void salvar(PrevisaoTempo previsao) {
		previsaoRepo.save(previsao);
	}
	
	public List<PrevisaoTempo> listarTodos() {
		List<PrevisaoTempo> previsoes = previsaoRepo.findAll();

		return previsoes;
	}
}