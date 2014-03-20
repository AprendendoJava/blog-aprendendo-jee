package org.jugvale.introducao.jpa.inicio;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jugvale.introducao.jpa.model.Produto;

@Singleton
@Startup
public class CarregaDadosIniciais {
	
	@PersistenceContext(unitName = "primary")
	EntityManager em;


	@PostConstruct
	public void carregaDadosIniciais() {
		Produto p1 = new Produto();
		p1.setNome("Produto1"); p1.setPreco(200f);
		Produto p2 = new Produto();
		p2.setNome("Produto2"); p2.setPreco(150f);
		em.persist(p1);
		em.persist(p2);
	}
}
