package br.usjt.hellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.usjt.hellospringboot.model.Dia;


public interface DiaRepository extends JpaRepository<Dia, Long>{

}