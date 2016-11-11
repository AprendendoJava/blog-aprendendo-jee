package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Escola;
import service.impl.EscolaServiceImpl;

@Path("escola")
public class EscolaResource {
	
	@Inject
	EscolaServiceImpl escolaService;
	
	@GET
	@Produces("application/json")
	public List<Escola> todas(@PathParam("id") long id){
		return escolaService.todos();
	}

}
