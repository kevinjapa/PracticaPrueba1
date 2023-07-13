package ec.edu.ups.ppw.negocio;

import java.util.List;

import ec.edu.ups.ppw.Datos.*;
import ec.edu.ups.ppw.Modelo.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProducto {
	
	@Inject
	private ProductoDAO daoProducto;
	
	public void guardarProducto(Producto producto) throws Exception{

			if(daoProducto.read(producto.getId_Producto())==null) {
				try {
					daoProducto.insert(producto);
				}
				catch(Exception e){
					throw new Exception("Error al ingresar:"+e.getMessage());
				}
			}else {
					try {
						daoProducto.update(producto);
					}
					catch(Exception e){
						throw new Exception("Error al Actualizar:"+e.getMessage());
						
					}
				}
			}
		
	
	public boolean isCodigoValido(int idProducto) {
		return idProducto == 0 || idProducto !=0;
	}
	
	public List<Producto> listaProducto(){
		return daoProducto.getAll();
	}
}
