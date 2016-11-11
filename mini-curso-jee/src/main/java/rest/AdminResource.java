package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 
 * Classe protegida para acesso somente de admins
 * 
 * @author ilha
 *
 */
@Path("admin")
public class AdminResource {
	
	/**
	 * Esse método é protegido no web.xml - só admins podem acessar ele
	 */
	@GET
	public void admin(){}

}
