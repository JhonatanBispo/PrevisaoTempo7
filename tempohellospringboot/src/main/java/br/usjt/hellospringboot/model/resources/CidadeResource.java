package br.usjt.hellospringboot.model.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.hellospringboot.model.Cidade;
import br.usjt.hellospringboot.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepo;
	
	
	
	@GetMapping("/{latitude}")
	public Cidade buscarPelaLat(@PathVariable Double latitude, Double longitude) {
		return cidadeRepo.findByLatitudeAndLongitude(latitude, longitude);
	}

	@GetMapping("/lista")
	public List<Cidade> todasAsCidades() {
		return cidadeRepo.findAll();
	}
	
	@GetMapping("/letra")
	public List<Cidade> todasCidadesLetra(String letra) {
		return cidadeRepo.findByNomeIgnoreCase(letra);
	}

	@PostMapping ("/salvar")
	//@ResponseStatus (HttpStatus.CREATED) agora desnecessária
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade l = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/cidades/{id}"). //na apostila faltou /livros
				buildAndExpand(l.getId()).
				toUri();
		//desnecessário também
		//response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(l);
	}

}
