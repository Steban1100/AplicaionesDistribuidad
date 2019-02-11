package ups.edu.ec.clase;

import java.util.Date;

/**
 * Esta clase es una clase intermedia que nos muetra los datos de un cliente con
 * su empresa
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
public class PersonaMostrar {

	private String cedula;
	private String nombre;
	private String celular;
	private String email;
	private Date fecha_naci;
	private String emp_persona;
	private String dir_emp_persona;
	private String email_emp_persona;
	private String empresa;

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

	public Date getFecha_naci() {
		return fecha_naci;
	}

	public void setFecha_naci(Date fecha_naci) {
		this.fecha_naci = fecha_naci;
	}

	public String getEmp_persona() {
		return emp_persona;
	}

	public void setEmp_persona(String emp_persona) {
		this.emp_persona = emp_persona;
	}

	public String getDir_emp_persona() {
		return dir_emp_persona;
	}

	public void setDir_emp_persona(String dir_emp_persona) {
		this.dir_emp_persona = dir_emp_persona;
	}

	public String getEmail_emp_persona() {
		return email_emp_persona;
	}

	public void setEmail_emp_persona(String email_emp_persona) {
		this.email_emp_persona = email_emp_persona;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
