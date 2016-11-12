package org.aprendendojee.ejb;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("sem-estado")
public class EJBSemEstado {

	@GET
	public String vai() {
		System.out.printf("Eu sou %s.\n", toString());
		return toString();
	}

}
