package br.usjt.hellospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.hellospringboot.model.Dia;
import br.usjt.hellospringboot.repository.DiaRepository;

@Service
public class DiaService {
	
	@Autowired
	private DiaRepository diaRepo;
	
	public void salvar(Dia dia) {
		diaRepo.save(dia);
	}
	
	public List<Dia> listarTodos() {
		List<Dia> dias = diaRepo.findAll();
		return dias;
	}
}
