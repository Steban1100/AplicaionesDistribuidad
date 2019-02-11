package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.dao.ActividadDao;
import ups.edu.ec.clase.ActividadMostrar;
import ups.edu.ec.clase.Actividades;

@Stateless
public class ActividadesNegocio{
	
	@Inject
	private ActividadDao Actdao;

	public boolean registrar(Actividades act) throws Exception {
		Actividades aux = Actdao.leer(act.getCodigo());
		if (aux != null)
			throw new Exception("Inmueble ya registrado");
		else
			Actdao.insertar(act);
		return true;
	}

	public Actividades leer(int codigo) throws Exception {
		Actividades actividades = Actdao.leer(codigo);
		if(actividades==null)
			throw new Exception("Actividad no registrada");
		return actividades;
	}

	public void actualizar(Actividades act) throws Exception  {
		Actividades aux = Actdao.leer(act.getCodigo());
		if (aux == null)
			throw new Exception("Actividad no registrado");
		else
			Actdao.actualizar(act);
		
	}

	public void eliminar(int codigo) throws Exception {
		Actividades actividades = Actdao.leer(codigo);
		if(actividades==null)
			throw new Exception("Actividad no registrada");
		else
			Actdao.borrar(codigo);
	}

	public List<Actividades> listarActividad() {
		return Actdao.listaActividades();
	}
	
	public List<ActividadMostrar> ActividadMostrar(int emp_per_codigo) {
		return Actdao.ActividadMostrar(emp_per_codigo);
		
	}

}