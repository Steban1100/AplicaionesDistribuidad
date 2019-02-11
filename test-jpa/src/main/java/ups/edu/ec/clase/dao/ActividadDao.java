package ups.edu.ec.clase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.clase.Actividades;
import ups.edu.ec.clase.ActividadMostrar;

@Stateless
public class ActividadDao {
	@Inject
	private EntityManager em;

	public void insertar(Actividades act) {
		em.persist(act);
	}

	public void actualizar(Actividades act) {
		em.merge(act);
	}

	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}

	public Actividades leer(int codigo) {
		Actividades aux = em.find(Actividades.class, codigo);
		return aux;
	}

	public List<Actividades> listaActividades() {
		String jpql = "SELECT a FROM Actividades a";
		Query query = em.createQuery(jpql, Actividades.class);
		List<Actividades> listadoActividades = query.getResultList();
		for (Actividades actividad : listadoActividades) {
			System.out.println(">>>>>>>>>>>" + actividad.getNombre() + ", " + actividad.getEmp_per_codigo().getCodigo()
					+ ", " + actividad.getSitio_alterno_codigo().getCodigo());
		}
		return listadoActividades;
	}

	public List<ActividadMostrar> ActividadMostrar(int emp_per_codigo) {
		String jpql = "SELECT act FROM Actividades act WHERE act.emp_per_codigo.codigo = ?1";
		Query query = em.createQuery(jpql, Actividades.class);
		query.setParameter(1, emp_per_codigo);
		List<Actividades> lista = query.getResultList();
		List<ActividadMostrar> listaact = new ArrayList<>();
		for (Actividades actividad : lista) {
			ActividadMostrar am = new ActividadMostrar();
			System.out.println(actividad.getEmp_per_codigo().getNombre());
			am.setEmp_persona(actividad.getEmp_per_codigo().getNombre());
			am.setDir_emp_persona(actividad.getEmp_per_codigo().getDireccion());
			am.setEmail_emp_persona(actividad.getEmp_per_codigo().getEmail());
			am.setNombre_actividad(actividad.getNombre());
			am.setTiempo_actividad(actividad.getTiempo());
			am.setUbicacion_sitio(actividad.getSitio_alterno_codigo().getUbicacion());
			am.setDescrip_sitio(actividad.getSitio_alterno_codigo().getDescripcion());
			listaact.add(am);
		}
		return listaact;
	}

}
