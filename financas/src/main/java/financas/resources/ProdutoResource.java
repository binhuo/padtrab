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

import financas.model.Produto;
import financas.service.ProdutoService;

@Path("/produtos")
public class ProdutoResource {
	private ProdutoService produtos = new ProdutoService();
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		return Response.ok(produtos).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") long id) {
		Produto _produto = produtos.get(id);
		if (_produto != null) {
			return Response.ok(_produto).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response add(Produto produto) {
		produtos.add(produto);
		return Response.ok(produto).build();
	}
	
	@PUT	
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Produto produto) {
		if (produtos.update(produto)) {
			return Response.ok(produto).build();				
		}
		return Response.status(Response.Status.NOT_FOUND).build();		
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") long id) {
		if (produtos.delete(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
		
}
