package ups.edu.ec.clase.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.Empresa;
@Stateless
public class EmpresaDao {
	@Inject
	private EntityManager em;
	
	public void insertar(Empresa emp) {
		em.persist(emp);
	}
	public void actualizar(Empresa emp) {
		em.merge(emp);
	}
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	public Empresa leer(int codigo) {
		Empresa aux=em.find(Empresa.class, codigo);
	return aux;
	}
	public List<Empresa> listaEmpresas() {
		String jpql = "SELECT emp FROM Empresa emp";
		Query query = em.createQuery(jpql, Empresa.class);
		List<Empresa> listadoEmpresas = query.getResultList();
		return listadoEmpresas;
	}

}
