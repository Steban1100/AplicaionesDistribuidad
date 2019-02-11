package ups.edu.ec.clase.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.SitioAlterno;

@Stateless
public class SitioAlternoDao {
	@Inject
	private EntityManager em;
	
	public void insertar(SitioAlterno sitio) {
		em.persist(sitio);
	}
	public void actualizar(SitioAlterno sitio) {
		em.merge(sitio);
	}
	public void borrar(int codigo) {
		em.remove(leer(codigo));
		
	}
	public SitioAlterno leer(int codigo) {
		SitioAlterno aux=em.find(SitioAlterno.class, codigo);
	return aux;
	}
	public List<SitioAlterno> listaSitioAlternos() {
		String jpql = "SELECT st FROM SitioAlterno st";
		Query query = em.createQuery(jpql, SitioAlterno.class);
		List<SitioAlterno> listadoSitioAlternos = query.getResultList();
		return listadoSitioAlternos;
	}

}
