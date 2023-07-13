package ec.edu.ups.ppw.negocio;

import ec.edu.ups.ppw.Datos.ProductoDAO;
import ec.edu.ups.ppw.Modelo.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;


@Singleton
@Startup

public class DatosDemo {
	
	@Inject
	ProductoDAO daoProducto;
	
	@PostConstruct
	public void init() {
		Producto p=new Producto();
		
		p.setNombre("banano");
		p.setDescripcion("Banano  de alta Calidad");
		p.setPrecio(160);
		
		//daoProducto.insert(p);
		System.out.print(p.toString());
	}
}
