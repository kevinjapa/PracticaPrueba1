package ec.edu.ups.ppw.Datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.Modelo.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO implements Serializable{
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    	}
	public void insert(Producto producto) {
		em.persist(producto);
	}
	public void update(Producto producto) {
		em.merge(producto);
	}
	public Producto read(int idProducto) {
		Producto p = em.find(Producto.class, idProducto);
		return p;
	}
	public void delete(int idProducto) {
		Producto p = em.find(Producto.class, idProducto);
		em.remove(p);
	}
	public List<Producto> getAll(){
	String jpql = "SELECT p FROM Producto p";
	Query q = em.createQuery(jpql);
	return q.getResultList();
	}


}
