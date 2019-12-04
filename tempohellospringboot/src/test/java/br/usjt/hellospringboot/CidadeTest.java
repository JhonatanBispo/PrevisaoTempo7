package br.usjt.hellospringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.usjt.hellospringboot.model.Cidade;
import br.usjt.hellospringboot.repository.CidadeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeTest {

	@Autowired
	private CidadeRepository cidadeRepo;

	@Test
	public void findLatAndLongTest() {
		Cidade c = cidadeRepo.findByLatitudeAndLongitude(180.55, 55.27);
		System.out.println(c);
	}

	@Test
	public void findNomeTest() {
		Cidade c = (Cidade) cidadeRepo.findByNome("palmiras");
		System.out.println(c);
	}

	@Test
	public void findNomeIgnoreTest() {
		Cidade c = (Cidade) cidadeRepo.findByNomeIgnoreCase("sao camilo");
		System.out.println(c);
	}


}
