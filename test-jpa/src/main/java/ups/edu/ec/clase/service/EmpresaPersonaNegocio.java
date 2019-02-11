package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.dao.EmpresaPersonaDao;
import ups.edu.ec.clase.EmpresaPersona;

@Stateless
public class EmpresaPersonaNegocio{

	@Inject
	private EmpresaPersonaDao empperdao;

	public void registrar(EmpresaPersona empper)throws Exception {
		EmpresaPersona aux = empperdao.leer(empper.getCodigo());
		if (aux != null)
			throw new Exception("Empresa persona ya registrado");
		else
			empperdao.insertar(empper);
		
	}

	public EmpresaPersona leer(int codigo) throws Exception{
		EmpresaPersona empresapersonas = empperdao.leer(codigo);
		if(empresapersonas==null)
			throw new Exception("Actividad no registrada");
		return empresapersonas;
	}

	public void actualizar(EmpresaPersona empper)throws Exception {
		EmpresaPersona aux = empperdao.leer(empper.getCodigo());
		if (aux == null)
			throw new Exception("Empresa persona no registrado");
		else
			empperdao.actualizar(empper);
		
	}

	public void eliminar(int codigo) throws Exception{
		EmpresaPersona empresapersonas = empperdao.leer(codigo);
		if(empresapersonas==null)
			throw new Exception("Empresa persona no registrada");
		else
			empperdao.borrar(codigo);
	}
	
	public List<EmpresaPersona> listarEmpresaPersona() {
		return empperdao.listaEmpresaPersonas();
	}

}
