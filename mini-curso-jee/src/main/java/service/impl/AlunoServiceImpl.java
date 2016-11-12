package service.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Aluno;
import service.Service;

@Stateless
public class AlunoServiceImpl extends Service<Aluno> {

	@PersistenceContext
	EntityManager em;
	
	public Aluno buscaPorRA(String RA) {
		TypedQuery<Aluno> query = em.createQuery(
				"select a from Aluno A where a.ra = :ra", 
				Aluno.class);
		query.setParameter("ra", RA);
		return query.getSingleResult();
	}

}
