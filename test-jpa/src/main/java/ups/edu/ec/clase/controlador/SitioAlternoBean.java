package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.SitioAlternoNegocio;
import ups.edu.ec.clase.SitioAlterno;

@ManagedBean
@ViewScoped
public class SitioAlternoBean {
	@Inject
	private SitioAlternoNegocio sitlocal;
	@Inject
	private FacesContext facesContext;
	private SitioAlterno st;
	private List<SitioAlterno> sitioalternos;
	private int id;
	private boolean edit=false;

	@PostConstruct
	public void init() {
		st = new SitioAlterno();
		sitioalternos = sitlocal.listarSitioAlterno();
	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			st = sitlocal.leer(id);
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
				sitlocal.actualizar(st);
			else
				sitlocal.registrar(st);
			return "SitioAlterno?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(SitioAlterno st) {
		edit = false;
		return "SitioAlterno?faces-redirect=true&id=" + st.getCodigo();
	}
	
	public void eliminar(int id) {
		try {
			sitlocal.eliminar(id);
			System.out.println("Actividad eliminada");
			
			
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String regresar() {
		return "SitioAlterno";
	}

	public SitioAlterno getSitio() {
		return st;
	}

	public void setSitio(SitioAlterno st) {
		this.st = st;
	}

	public List<SitioAlterno> getSitioalternos() {
		return sitioalternos;
	}

	public void setSitioalternos(List<SitioAlterno> sitioalternos) {
		this.sitioalternos = sitioalternos;
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
