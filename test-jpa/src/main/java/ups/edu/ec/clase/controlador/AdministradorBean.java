package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.AdministradorNegocio;
import ups.edu.ec.clase.service.EmpresaNegocio;
import ups.edu.ec.clase.Administrador;
import ups.edu.ec.clase.Empresa;

@ManagedBean
@ViewScoped
public class AdministradorBean {

	@Inject
	private AdministradorNegocio adminlocal;
	@Inject
	private FacesContext facesContext;
	@Inject
	private EmpresaNegocio en;
	private List<Empresa> empresas;
	private Administrador admin;
	private List<Administrador> administradores;
	private int id;
	private boolean edit=false;
	private int codigoEmpresa;
	private Empresa emp;

	@PostConstruct
	private void init() {
		admin = new Administrador();
		administradores = adminlocal.listarAdministrador();
		empresas= en.listarEmpresa();
		System.out.println("BeanAadministradpr");
		for ( Empresa empresa : empresas) {
			System.out.println("<<<<<<<<<<<>>>>>>>>>>>>>>"+empresa.getCodigo());
		}
		
	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			admin = adminlocal.leer(id);
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
	}

	public String guardar() {
		try {
			if (edit) {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				admin.setEmp_codigo(emp);
				adminlocal.actualizar(admin);
			}else {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				admin.setEmp_codigo(emp);
				adminlocal.registrar(admin);
			return "SitioAdministrador?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
		return null;
	}
	
	public String guardar1() {
		try {
			if (edit) {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				admin.setEmp_codigo(emp);
				adminlocal.actualizar(admin);
			}else {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				admin.setEmp_codigo(emp);
				adminlocal.registrar(admin);
			return "SitioAdministrador2?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
		return null;
	}

	public String editar(Administrador admin) {
		edit = false;
		return "SitioAdministrador?faces-redirect=true&id=" + admin.getCodigo();
	}
	
	public void eliminar(int id) {
		try {
			adminlocal.eliminar(id);
			System.out.println("Persona eliminada");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
	}

	public String regresar() {
		return "SitioAdministrador";
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
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

	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	

	

}
