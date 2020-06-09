package financas.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import financas.model.Usuario;
import financas.service.UsuarioService;

@Path("/usuarios")
public class UsuarioResources{
	private UsuarioService usuarios = new UsuarioService();
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		return Response.ok(usuarios).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") long id) {
		Usuario _usuario = usuarios.get(id);
		if (_usuario != null) {
			return Response.ok(_usuario).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response add(Usuario usuario) {
		usuarios.add(usuario);
		return Response.ok(usuario).build();
	}
	
	@PUT	
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Usuario usuario) {
		if (usuarios.update(usuario)) {
			return Response.ok(usuario).build();				
		}
		return Response.status(Response.Status.NOT_FOUND).build();		
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") long id) {
		
		if (usuarios.delete(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
