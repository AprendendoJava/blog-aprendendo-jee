package org.jugvale.introducao.jpa.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import javax.persistence.*;
import java.util.List;
import org.jugvale.introducao.jpa.model.Produto;
import javax.ejb.Stateless;

@Path("produto")
@Produces("application/json")
@Stateless
public class ProdutoEndpoint{

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@GET
	public List<Produto> buscarTodos(){
		return em.createQuery("SELECT p FROM Produto p").getResultList();
	}

	@POST
	@Consumes("application/json")
	public Response criar(Produto p){
		em.persist(p);
		return Response.created(UriBuilder.fromResource(ProdutoEndpoint.class)
				  .path(String.valueOf(p.getId())).build()).build();
	}

	@GET
	@Path("{id}")
	public Produto recuperaPorId(@PathParam("id") long id){
		Produto p =  em.find(Produto.class, id);
		 if(p == null)naoEncontrado(id);
		 return p;
	}

	@DELETE
	@Path("{id}")
	public void apagar(@PathParam("id") long id){
		Produto p = recuperaPorId(id);
		em.remove(p);
	}
	private void naoEncontrado(long id){
		throw new WebApplicationException(Response.status(Status.NOT_FOUND)
						.entity("Produto com ID '"+ id + "' não encontrado").build());
	}
}
