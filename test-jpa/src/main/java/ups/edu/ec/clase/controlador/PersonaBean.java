package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.EmpresaNegocio;
import ups.edu.ec.clase.service.EmpresaPersonaNegocio;
import ups.edu.ec.clase.service.PersonaService;
import ups.edu.ec.clase.Empresa;
import ups.edu.ec.clase.EmpresaPersona;
import ups.edu.ec.clase.Persona;

@ManagedBean
@ViewScoped
public class PersonaBean {
	
	@Inject
	private PersonaService perlocal;
	@Inject
	private FacesContext facesContext;
	@Inject
	private EmpresaNegocio en;
	@Inject
	private EmpresaPersonaNegocio epn;
	private Persona per;
	private List<Persona> personas;
	private int id;
	private boolean edit=false;
	
	private Empresa emp;
	private EmpresaPersona empper;
	
	private List<Empresa> empresas;
	private int codigoEmpresa;
	
	private List<EmpresaPersona> empresaPersonas;
	private int codigoEmpresaPersona;
	
	@PostConstruct
	public void init() {
		per= new Persona();
		personas = perlocal.listarPersona();
		empresas= en.listarEmpresa();
		empresaPersonas= epn.listarEmpresaPersona();
	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			per = perlocal.leer(id);
			edit = true;
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
			
			e.printStackTrace();
		}
	}

	public String guardar() {
		System.out.println(edit);
		try {
			if (edit == true) {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				per.setEmp_codigo(emp);
				empper= new EmpresaPersona();
				empper.setCodigo(codigoEmpresaPersona);
				per.setEmp_per_codigo(empper);
				perlocal.actualizar(per);
				
			}else {
				emp = new Empresa();
				emp.setCodigo(codigoEmpresa);
				per.setEmp_codigo(emp);
				empper= new EmpresaPersona();
				empper.setCodigo(codigoEmpresaPersona);
				per.setEmp_per_codigo(empper);
				perlocal.registrar(per);
			
			return "SitioPersona?faces-redirect=true";
			}
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
		
	}

	public String editar(Persona per) {
		edit = false;
		return "SitioPersona?faces-redirect=true&id=" + per.getCodigo();
	}
	
	public void eliminar(int id) {
		try {
			perlocal.eliminar(id);
			System.out.println("Actividad eliminada");
			
			
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String regresar() {
		edit = true;
		return "SitioPersona";
	}

	public Persona getPersona() {
		return per;
	}

	public void setPersona(Persona per) {
		this.per = per;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
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

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public List<EmpresaPersona> getEmpresaPersonas() {
		return empresaPersonas;
	}

	public void setEmpresaPersonas(List<EmpresaPersona> empresaPersonas) {
		this.empresaPersonas = empresaPersonas;
	}

	public int getCodigoEmpresaPersona() {
		return codigoEmpresaPersona;
	}

	public void setCodigoEmpresaPersona(int codigoEmpresaPersona) {
		this.codigoEmpresaPersona = codigoEmpresaPersona;
	}
	
	
	

}

