package ups.edu.ec.clase;

import java.util.Date;

/**
 * Esta es una clase intermedia que nos muestra todo los datos de una persona
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
public class PM {

	private int codigo;
	private String cedula;
	private String nombre;
	private String celular;
	private String email;
	private String contrasena;
	private Date fecha;
	private int empresa;
	private int empresa_persona;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public int getEmpresa_persona() {
		return empresa_persona;
	}

	public void setEmpresa_persona(int empresa_persona) {
		this.empresa_persona = empresa_persona;
	}

}
