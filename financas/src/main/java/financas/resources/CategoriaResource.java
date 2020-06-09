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

import financas.model.Categoria;
import financas.service.CategoriaService;

@Path("/categorias")
public class CategoriaResource {
	private CategoriaService categorias = new CategoriaService();
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		return Response.ok(categorias).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") long id) {
		Categoria _categoria = categorias.get(id);
		if (_categoria != null) {
			return Response.ok(_categoria).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response add(Categoria categoria) {
		categorias.add(categoria);
		return Response.ok(categoria).build();
	}
	
	@PUT	
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Categoria categoria) {
		if (categorias.update(categoria)) {
			return Response.ok(categoria).build();				
		}
		return Response.status(Response.Status.NOT_FOUND).build();		
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") long id) {
		if (categorias.delete(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
		
}
