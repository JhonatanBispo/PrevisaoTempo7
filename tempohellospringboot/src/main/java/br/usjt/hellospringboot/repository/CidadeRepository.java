package br.usjt.hellospringboot.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.usjt.hellospringboot.model.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Async
	public Future<List<Cidade>> findByNome (String nome);
	

	
	public Cidade findByLatitudeAndLongitude (Double latitude, Double longitude); 
	
	@Query("SELECT c FROM Cidade c WHERE c.nome = :nome")
	public Cidade findByNome1 (String nome);
	
	@Query("SELECT c FROM Cidade c WHERE c.nome ILIKE ?%")
	public List<Cidade> findByNomeIgnoreCase (String nome);
	

}
