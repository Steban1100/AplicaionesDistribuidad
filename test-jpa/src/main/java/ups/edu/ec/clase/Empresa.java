package ups.edu.ec.clase;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * Esta clase crea la tabla empresa con todos sus parametros
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
@Entity
@Table(name = "tbl_empresa")
public class Empresa {
	@Id
	@NotNull
	@Column(name = "emp_codigo", length = 4)
	private int codigo;

	@NotNull
	@Column(name = "emp_nombre")
	private String nombre;

	@NotNull
	@Column(name = "emp_direccion")
	private String direccion;

	@NotNull
	@Email
	@Column(name = "emp_email")
	private String email;

	@OneToMany(mappedBy = "emp_codigo")
	private List<Administrador> listaAdministradores;

	@OneToMany(mappedBy = "emp_codigo")
	private List<Persona> listaPersonas;

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

	public List<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email
				+ "]";
	}

}
