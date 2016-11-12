package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import model.Aluno;
import model.Curso;
import model.Inscricao;
import service.impl.AlunoServiceImpl;
import service.impl.CursoServiceImpl;

@Stateless
@Path("/curso")
public class CursoResource {
	
	@Inject
	CursoServiceImpl cursoService;
	
	@Inject
	AlunoServiceImpl alunoService;
	
	@GET
	@Produces("application/json")
	public List<Curso> todosCursos() {
		return cursoService.todos();
	}
	
	
	@POST
	@Consumes("application/json")
	public void cria(Curso curso) {
		cursoService.salvar(curso);
	}
	
//	@PUT
//	@Consumes("application/json")
//	public void atualiza(Curso curso) {
//		Não Implementado
//		cursoService.atualizar(curso);
//	}
	
	@GET
	@Path("{id: [0-9]+}")
	@Produces("application/json")
	public Curso buscaPorId(@PathParam("id") long id) {
		return cursoService.buscarPorId(id);
	}
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public void apagaPorId(@PathParam("id") long id) {
		Curso c = cursoService.buscarPorId(id);
		cursoService.remover(c);
	}
	
	@GET
	@Path("{nome}")
	@Produces("application/json")
	public List<Curso> buscaPorNome(@PathParam("nome") String nome) {
		return cursoService.buscaPorNome(nome);
	}
	
	
	@GET
	@Path("{id}/inscritos")
	@Produces("application/json")
	public List<Aluno> inscrito(@PathParam("id") long id) {
		return cursoService.buscaInscritos(id);
	}
	
	@POST
	@Path("{id}/inscritos/{RA}")
	@Produces("application/json")
	public Inscricao inscrever(@PathParam("id") long id, String raAluno) {
		Curso c = cursoService.buscarPorId(id);
		if(c.getVagas() < 1) {
			throw new WebApplicationException("Não mais vagas nesse curso", Response.Status.BAD_REQUEST);
		}
		Aluno a = alunoService.buscaPorRA(raAluno);
		return cursoService.inscrever(c, a);
	}
	
}