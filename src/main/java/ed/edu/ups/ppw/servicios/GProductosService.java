package ed.edu.ups.ppw.servicios;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.Modelo.Producto;
import ec.edu.ups.ppw.demo.modelo.Cliente;
import ec.edu.ups.ppw.negocio.GestionProducto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("productos")
public class GProductosService {
	
	@Inject 
	private GestionProducto gestionProducto;
	
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola Mundo";
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Producto misDatos() {
		Producto p = new Producto();
		p.setDescripcion("dsccsd");
		p.setNombre("kjndanskjdans");
		return p;
	}
	
	
	
	
	
	//Nos ayuda a listar a los productos
	@GET
	@Path("listaProducto")
	@Produces("application/json")
	public List<Producto> datos() {
	    return gestionProducto.listaProducto();
	}
	//nos ayuda a crear productos desde la pagina 
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarProducto(Producto producto)
	{
		try {
			gestionProducto.guardarProducto(producto);
			return Response.status(Response.Status.OK).entity(producto).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			Error error =new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(producto).build();
		}
	}
}
