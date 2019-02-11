package ups.edu.ec.clase.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.Administrador;
import ups.edu.ec.clase.Persona;


public class LoginDao {
	
	@Inject 
	private EntityManager em;
	
	

	public Administrador BuscarLog(String email, String contrasena) {
		try {
		
		Query query = em.createQuery("SELECT a FROM Administrador a WHERE a.email = :email AND a.contrasena = :contrasena" , Administrador.class); 
		query.setParameter("email", email);
		query.setParameter("contrasena", contrasena);
		Administrador adulto = (Administrador) query.getSingleResult();
	    System.out.println("adulto encontrado "+adulto.getNombre());
	    if(adulto!=null)
		return adulto;
	    
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
