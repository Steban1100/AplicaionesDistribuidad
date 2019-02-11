package ups.edu.ec.clase.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.EmpresaPersona;

@Stateless
public class EmpresaPersonaDao {
	@Inject
	private EntityManager em;
	public void insertar(EmpresaPersona empper) {
		em.persist(empper);
	}
	public void actualizar(EmpresaPersona empper) {
		em.merge(empper);
		
	}
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	public EmpresaPersona leer(int codigo) {
		EmpresaPersona aux=em.find(EmpresaPersona.class, codigo);
		return aux;
	}
	public List<EmpresaPersona> listaEmpresaPersonas() {
		String jpql = "SELECT empper FROM EmpresaPersona empper";
		Query query = em.createQuery(jpql, EmpresaPersona.class);
		List<EmpresaPersona> listadoEmpresaPersonas= query.getResultList();
		return listadoEmpresaPersonas;
	}

}
