package org.aprendendojee.ejb;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path("singleton")
public class EJBSingleton {

	@GET
	public String vai() {
		System.out.printf("Eu sou %s.\n", toString());
		return toString();
	}
	
	@GET
	@Path("dorminhoco")
	public String dorminhoco() throws InterruptedException {
		System.out.printf("Eu sou %s e dorminhoco...\n", toString());
		Thread.sleep(1000);
		return toString();
	}

}
