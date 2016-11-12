package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import model.Aluno;
import model.Curso;
import model.Inscricao;
import service.Service;

@Stateless
public class CursoServiceImpl extends Service<Curso>{

	public List<Curso> buscaPorNome(String nome) {
		TypedQuery<Curso> query = em.createQuery(
				"select c from Curso c where c.nome like :nome", 
				Curso.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	public Inscricao inscrever(Curso curso, Aluno aluno) {
		if(curso.getVagas() < 1) {
			throw new IllegalArgumentException("O curso não tem mais vagas");
		}
		curso.setVagas(curso.getVagas() - 1);
		Inscricao i = new Inscricao();
		i.setAluno(aluno);
		i.setCurso(curso);
		i.setDataInscricao(new Date());
		em.persist(i);
		atualizar(curso);
		return i;
	}

	public List<Aluno> buscaInscritos(long id) {
		TypedQuery<Inscricao> query = em.createQuery(
				"select i from Inscricao i where i.curso.id  = :id", 
				Inscricao.class);
		query.setParameter("id", id);
		List<Inscricao> inscricoes = query.getResultList();
		
		List<Aluno> alunos = new ArrayList<>();
		for (Inscricao inc : inscricoes) {
			alunos.add(inc.getAluno());
		}
//		return inscricoes.stream()
//				.map(Inscricao::getAluno)
//				.collect(Collectors.toList());
		return alunos;
	}
}