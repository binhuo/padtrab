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

import financas.model.Produtor;
import financas.service.ProdutorService;

@Path("/produtores")
public class ProdutorResource {
	private ProdutorService produtores = new ProdutorService();
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		return Response.ok(produtores).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") long id) {
		Produtor _produtor = produtores.get(id);
		if (_produtor != null) {
			return Response.ok(_produtor).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response add(Produtor produtor) {
		produtores.add(produtor);
		return Response.ok(produtor).build();
	}
	
	@PUT	
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Produtor produtor) {
		if (produtores.update(produtor)) {
			return Response.ok(produtor).build();				
		}
		return Response.status(Response.Status.NOT_FOUND).build();		
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") long id) {
		if (produtores.delete(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
		
}
