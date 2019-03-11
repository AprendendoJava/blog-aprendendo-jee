package org.jugvale.rest;

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

import org.jugvale.model.Produto;
import org.jugvale.service.ProdutoService;

@Path("produto")
@Produces("application/json;charset=utf-8")
@Stateless
public class ProdutoResource {
	
	@Inject
	ProdutoService service;
		
	@POST
	@Consumes("application/json;charset=utf-8")
	public void salvar(Produto p) {
		service.salvar(p);
	}

	@DELETE
	@Path("{id}")
	public void apagar(@PathParam("id") long id) {
		Produto p = service.buscarPorId(id);
		service.apagar(p);
	}

	
	@GET
	@Path("{id}")
	public Produto buscaPorId(@PathParam("id") long id) {
		return service.buscarPorId(id);
	}
	@GET
	public List<Produto> buscarTodos() {
		return service.buscarTodos();
	}

}
