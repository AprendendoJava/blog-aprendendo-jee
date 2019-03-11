package org.jugvale.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jugvale.model.Produto;

@Stateless
public class ProdutoService {
	
	@PersistenceContext
	EntityManager em;

	public void salvar(Produto p) {
		em.persist(p);
	}

//	public void atualizar(Produto p) {
//		
//	}

	public void apagar(Produto p) {
		em.remove(p);
	}

	public Produto buscarPorId(long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos() {
		TypedQuery<Produto> buscaTodos = em.createQuery("select p from Produto p", Produto.class);
		return buscaTodos.getResultList();
	}

}
