package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.EmpresaNegocio;
import ups.edu.ec.clase.Empresa;

@ManagedBean
@ViewScoped
public class EmpresaBean {

	@Inject
	private EmpresaNegocio emplocal;
	@Inject
	private FacesContext facesContext;
	private Empresa emp;
	private List<Empresa> empresas;
	private int id;
	private boolean edit=false;

	@PostConstruct
	private void init() {
		emp = new Empresa();
		empresas = emplocal.listarEmpresa();
	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			emp = emplocal.leer(id);
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
	}

	public String guardar() {
		try {
			if (edit)
				emplocal.actualizar(emp);
			else
				emplocal.registrar(emp);
			return "SitioEmpresa?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
		return null;
	}

	public String editar(Empresa emp) {
		edit = false;
		return "SitioEmpresa?faces-redirect=true&id=" + emp.getCodigo();
	}
	
	public void eliminar(int id) {
		try {
			emplocal.eliminar(id);
			System.out.println("Actividad eliminada");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
	}

	public String regresar() {
		return "SitioEmpresa";
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Empresa getEmp() {
		return emp;
	}

	public void setEmp(Empresa emp) {
		this.emp = emp;
	}

}
