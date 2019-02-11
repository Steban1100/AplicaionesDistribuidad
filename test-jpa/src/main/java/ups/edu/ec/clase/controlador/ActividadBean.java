package ups.edu.ec.clase.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ups.edu.ec.clase.service.ActividadesNegocio;
import ups.edu.ec.clase.service.EmpresaPersonaNegocio;
import ups.edu.ec.clase.service.SitioAlternoNegocio;
import ups.edu.ec.clase.Actividades;
import ups.edu.ec.clase.Empresa;
import ups.edu.ec.clase.EmpresaPersona;
import ups.edu.ec.clase.SitioAlterno;

@ManagedBean
@ViewScoped
public class ActividadBean {

	@Inject
	private ActividadesNegocio actlocal;

	@Inject
	private EmpresaPersonaNegocio epn;
	@Inject
	private SitioAlternoNegocio stn;

	@Inject
	private FacesContext facesContext;
	private Actividades act;
	private List<Actividades> actividades;
	private int id;
	private boolean edit = false;

	private EmpresaPersona empper;
	private SitioAlterno sitalt;

	private List<EmpresaPersona> empresaPersonas;
	private int codigoEmpresaPersona;

	private List<SitioAlterno> sitioAlternos;
	private int codigoSitioAlterno;

	@PostConstruct
	private void init() {
		act = new Actividades();
		actividades = actlocal.listarActividad();
		empresaPersonas = epn.listarEmpresaPersona();
		sitioAlternos = stn.listarSitioAlterno();

	}

	public void cargar() {
		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			act = actlocal.leer(id);
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
				empper = new EmpresaPersona();
				empper.setCodigo(codigoEmpresaPersona);
				act.setEmp_per_codigo(empper);
				sitalt = new SitioAlterno();
				sitalt.setCodigo(codigoSitioAlterno);
				act.setSitio_alterno_codigo(sitalt);
				actlocal.actualizar(act);
			} else {
				empper = new EmpresaPersona();
				empper.setCodigo(codigoEmpresaPersona);
				act.setEmp_per_codigo(empper);
				sitalt = new SitioAlterno();
				sitalt.setCodigo(codigoSitioAlterno);
				act.setSitio_alterno_codigo(sitalt);
				actlocal.registrar(act);
				return "SitioActividades?faces-redirect=true";
			}
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Actividades act) {
		edit = false;
		return "SitioActividades?faces-redirect=true&id=" + act.getCodigo();
	}

	public void eliminar(int id) {
		try {
			actlocal.eliminar(id);
			System.out.println("Actividad eliminada");

		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
	}

	public String regresar() {
		edit = true;
		return "SitioActividades";
	}

	public Actividades getAct() {
		return act;
	}

	public void setAct(Actividades act) {
		this.act = act;
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

	public List<Actividades> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividades> actividades) {
		this.actividades = actividades;
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

	public List<SitioAlterno> getSitioAlternos() {
		return sitioAlternos;
	}

	public void setSitioAlternos(List<SitioAlterno> sitioAlternos) {
		this.sitioAlternos = sitioAlternos;
	}

	public int getCodigoSitioAlterno() {
		return codigoSitioAlterno;
	}

	public void setCodigoSitioAlterno(int codigoSitioAlterno) {
		this.codigoSitioAlterno = codigoSitioAlterno;
	}
	
	
	

}
