package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.dao.AdministradorDao;
import ups.edu.ec.clase.Administrador;
@Stateless
public class AdministradorNegocio{

	@Inject
	private AdministradorDao Admindao;
	
	
	public void registrar(Administrador admin) throws Exception{
		Administrador aux = Admindao.leer(admin.getCodigo());
		if (aux != null)
			throw new Exception("Administrador ya registrado");
		else
			Admindao.insertar(admin);
	}

	
	public Administrador leer(int codigo) throws Exception{
		Administrador administradores = Admindao.leer(codigo);
		if(administradores==null)
			throw new Exception("Actividad no registrada");
		return administradores;
	}

	
	public void actualizar(Administrador admin) throws Exception {
		Administrador aux = Admindao.leer(admin.getCodigo());
		if (aux == null)
			throw new Exception("Administrador no registrado");
		else
			Admindao.actualizar(admin);
		
	}

	
	public void eliminar(int codigo) throws Exception{
		Administrador administradores = Admindao.leer(codigo);
		if(administradores==null)
			throw new Exception("Actividad no registrada");
		else
			Admindao.borrar(codigo);
		
	}

	public List<Administrador> listarAdministrador() {
		return Admindao.listaAdministradores();
	}

}
