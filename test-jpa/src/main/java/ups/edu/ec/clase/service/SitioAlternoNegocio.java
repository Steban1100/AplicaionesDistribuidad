package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.dao.SitioAlternoDao;
import ups.edu.ec.clase.SitioAlterno;

@Stateless
public class SitioAlternoNegocio {

	@Inject
	private SitioAlternoDao Sitdao;
	
	public void registrar(SitioAlterno st) throws Exception{
		SitioAlterno aux = Sitdao.leer(st.getCodigo());
		if (aux != null)
			throw new Exception("Sitio Alterno ya registrado");
		else
			Sitdao.insertar(st);		
	}

	public SitioAlterno leer(int codigo)throws Exception {
		SitioAlterno sitioalternos = Sitdao.leer(codigo);
		if(sitioalternos==null)
			throw new Exception("Sitio Alterno no registrada");
		return sitioalternos;
	}

	public void actualizar(SitioAlterno st) throws Exception{
		SitioAlterno aux = Sitdao.leer(st.getCodigo());
		if (aux == null)
			throw new Exception("Sitio Alterno no registrado");
		else
			Sitdao.actualizar(st);		
	}

	public void eliminar(int codigo) throws Exception{
		SitioAlterno sitioalternos = Sitdao.leer(codigo);
		if(sitioalternos==null)
			throw new Exception("Sitio Alterno no registrada");
		else
			Sitdao.borrar(codigo);
		
	}

	public List<SitioAlterno> listarSitioAlterno() {
		return Sitdao.listaSitioAlternos();
	}

}
