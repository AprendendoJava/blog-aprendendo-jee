package org.jugvale.crud.rest;

import java.net.URI;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jugvale.crud.model.Encontro;
import org.jugvale.crud.service.EncontroService;

@Path("/encontro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EncontroResource {

    @Inject
    EncontroService encontroService;

    @GET
    @PermitAll
    public List<Encontro> lista() {
        return encontroService.lista();
    }
    
    @PUT
    @RolesAllowed("admin")
    public Response cria(Encontro encontro) {
        long id = encontroService.cria(encontro);
        return Response.created(URI.create("http://localhost:8080/encontro/" + id))
                       .build();
    }
    
    @GET
    @Path("{id}")
    @PermitAll
    public Encontro porId(@PathParam("id") long id) {
        return encontroService.porId(id);
    }
    
    @DELETE
    @Path("{id}")
    @RolesAllowed("admin")
    public void apaga(@PathParam("id") long id) {
        Encontro encontro = encontroService.porId(id);
        if (encontro == null) {
            throw new WebApplicationException(404);
        }
        encontroService.apagar(id);
    }
}
