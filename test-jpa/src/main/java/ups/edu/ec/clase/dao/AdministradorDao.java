package ups.edu.ec.clase.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.Administrador;
import ups.edu.ec.clase.Persona;
@Stateless
public class AdministradorDao {

	@Inject
	private EntityManager em;
	public void insertar(Administrador admin) {
		em.persist(admin);
	}
	public void actualizar(Administrador admin) {
		em.merge(admin);
	}
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	public Administrador leer(int codigo) {
		Administrador aux=em.find(Administrador.class, codigo);
	return aux;
	}
	public List<Administrador> listaAdministradores() {
		String jpql = "SELECT ad FROM Administrador ad";
		Query query = em.createQuery(jpql, Administrador.class);
		List<Administrador> listadoAdministradores = query.getResultList();
		for (Administrador administrador : listadoAdministradores) {
			System.out.println(">>>>>>>>>>>"+administrador.getNombre()+", "+administrador.getEmp_codigo().getCodigo());
		}
		return listadoAdministradores;
	}
}
