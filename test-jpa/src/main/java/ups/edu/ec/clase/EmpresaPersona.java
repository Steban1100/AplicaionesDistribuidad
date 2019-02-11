package ups.edu.ec.clase;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * Esta clase crea tabla empresa de la persona con todos sus parametros
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
@Entity
@Table(name = "tbl_empresa_persona")
public class EmpresaPersona {
	@Id
	@NotNull
	@Column(name = "emp_per_codigo", length = 4)
	private int codigo;

	@NotNull
	@Column(name = "emp_per_nombre")
	private String nombre;

	@NotNull
	@Column(name = "emp_per_direccion")
	private String direccion;

	@NotNull
	@Email
	@Column(name = "emp_per_email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "emp_per_codigo")
	private Persona empresaPersona;

	@OneToMany(mappedBy = "emp_per_codigo")
	private List<Actividades> listaActividades;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Persona getEmpresaPersona() {
		return empresaPersona;
	}

	public void setEmpresaPersona(Persona empresaPersona) {
		this.empresaPersona = empresaPersona;
	}

	public List<Actividades> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividades> listaActividades) {
		this.listaActividades = listaActividades;
	}

	@Override
	public String toString() {
		return "EmpresaPersona [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", email="
				+ email + "]";
	}

}
