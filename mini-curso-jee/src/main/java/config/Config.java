package config;

import java.util.Date;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Aluno;
import model.Curso;
import model.Escola;

@Startup
@Singleton
public class Config {
	
	@PersistenceContext
	EntityManager em;
		
	@PostConstruct
	public void configura() {
		Escola e = new Escola();
		e.setEndereco("Eugenio de Melo");
		e.setNome("FATEC");
		
		Curso c = new Curso();
		c.setNome("Aprendendo Java EE");
		c.setInicio(new Date());
		c.setFim(new Date());
		c.setDescricao("Aprender Java EE");
		c.setPreRequisito("Java Básico");
		c.setSala("412");
		c.setVagas(10);
		c.setEscola(e);
		
		Aluno a1 = new Aluno();
		a1.setLogin("john");
		a1.setRa("12");
		a1.setNome("John Smith");
		a1.setEscola(e);
		
		Aluno a2 = new Aluno();
		a2.setLogin("mary");
		a2.setRa("13");
		a2.setNome("Mary Smith");
		a2.setEscola(e);
		
		Aluno a3 = new Aluno();
		a3.setLogin("mary");
		a3.setRa("13");
		a3.setNome("Mary Smith");
		a3.setEscola(e);
		
		Stream.of(e, c, a1,a2,a3).forEach(em::persist);
	}

}
