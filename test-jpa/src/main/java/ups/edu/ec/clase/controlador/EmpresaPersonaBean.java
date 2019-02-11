package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.EmpresaPersonaNegocio;
import ups.edu.ec.clase.EmpresaPersona;

@ManagedBean
@ViewScoped
public class EmpresaPersonaBean {

	@Inject
	private EmpresaPersonaNegocio empperlocal;
	@Inject
	private FacesContext facesContext;
	private EmpresaPersona empper;
	private List<EmpresaPersona> empresapersonas;
	private int id;
	private boolean edit=false;

	@PostConstruct
	private void init() {
		empper = new EmpresaPersona();
		empresapersonas = empperlocal.listarEmpresaPersona();
	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			empper = empperlocal.leer(id);
			edit = true;
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String guardar() {
		try {
			if (edit)
				empperlocal.actualizar(empper);
			else
				empperlocal.registrar(empper);
			return "SitioEmpresaPersona?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(EmpresaPersona empper) {
		edit = false;
		return "SitioEmpresaPersona?faces-redirect=true&id=" + empper.getCodigo();
	}
	
	public void eliminar(int id) {
		try {
			empperlocal.eliminar(id);
			System.out.println("Actividad eliminada");
			
			
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String regresar() {
		return "SitioEmpresaPersona";
	}

	public EmpresaPersona getEmpper() {
		return empper;
	}

	public void setEmpper(EmpresaPersona empper) {
		this.empper = empper;
	}

	public List<EmpresaPersona> getEmpresapersonas() {
		return empresapersonas;
	}

	public void setEmpresapersonas(List<EmpresaPersona> empresapersonas) {
		this.empresapersonas = empresapersonas;
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

}
