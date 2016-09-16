package org.aprendendojee.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoService {

	@PersistenceContext
	EntityManager em;

	@GET
	public List<Produto> buscarTodos() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	@POST
	public Produto criar(Produto produto) {
		em.persist(produto);
		return produto;
	}

	@PUT
	public Produto atualizar(Produto produto) {
		return em.merge(produto);
	}

	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		Produto p = em.find(Produto.class, id);
		em.remove(p);
	}

}