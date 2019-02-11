package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.dao.EmpresaDao;
import ups.edu.ec.clase.Empresa;

@Stateless
public class EmpresaNegocio {
	
	@Inject
	private EmpresaDao Empdao;
	
	
	public void registrar(Empresa emp) throws Exception {
		Empresa aux = Empdao.leer(emp.getCodigo());
		if (aux != null)
			throw new Exception("Empresa ya registrado");
		else
			Empdao.insertar(emp);
		
	}

	public Empresa leer(int codigo) throws Exception{
		Empresa empresas = Empdao.leer(codigo);
		if(empresas==null)
			throw new Exception("Empresa no registrada");
		return empresas;
	}

	public void actualizar(Empresa emp) throws Exception {
		Empresa aux = Empdao.leer(emp.getCodigo());
		if (aux == null)
			throw new Exception("Empresa no registrado");
		else
			Empdao.actualizar(emp);;
		
	}


	public void eliminar(int codigo) throws Exception {
		Empresa empresas = Empdao.leer(codigo);
		if(empresas==null)
			throw new Exception("Empresa no registrada");
		else
			Empdao.borrar(codigo);
		
	}


	public List<Empresa> listarEmpresa() {
		return Empdao.listaEmpresas();
	}
	

}
