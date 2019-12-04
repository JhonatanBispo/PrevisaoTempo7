package br.usjt.hellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.usjt.hellospringboot.model.PrevisaoTempo;

public interface PrevisaoTempoRepository extends JpaRepository<PrevisaoTempo, Long>{

}
