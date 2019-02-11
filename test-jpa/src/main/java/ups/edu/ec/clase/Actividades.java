package ups.edu.ec.clase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Esta clase crea la tabla activdades con sus parametros
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
@Entity
@Table(name = "tbl_actividad")
public class Actividades {

	@Id
	@NotNull
	@Column(name = "act_codigo", length = 4)
	private int codigo;

	@NotNull
	@Column(name = "act_nombre")
	private String nombre;

	@NotNull
	@Column(name = "act_nivel")
	private String nivel;

	@NotNull
	@Column(name = "act_tiempo")
	private String tiempo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_per_codigo")
	private EmpresaPersona emp_per_codigo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sitio_alterno_codigo")
	private SitioAlterno sitio_alterno_codigo;

	/**
	 * Este metodo retorna el codigo de la actividad
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Este metodo recibe el parametor codigo
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Este metodo retorna el nombre de la actividad
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo recibe el nombre de la actividad
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo retorna el nivel de importancia de la actividad
	 * 
	 * @return
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * Este metodo rebine el nivel de importancia de la actividad
	 * 
	 * @param nivel
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * Este metodo retorna la duracion de la actividad
	 * 
	 * @return
	 */
	public String getTiempo() {
		return tiempo;
	}

	/**
	 * Este metodo recibe la diracion de la avtividad
	 * 
	 * @param tiempo
	 */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * Este metodo retorna el codigo de la empresa persona
	 * 
	 * @return
	 */
	public EmpresaPersona getEmp_per_codigo() {
		return emp_per_codigo;
	}

	/**
	 * Este metodo recibe el codigo de la empresa persona
	 * 
	 * @param emp_per_codigo
	 */
	public void setEmp_per_codigo(EmpresaPersona emp_per_codigo) {
		this.emp_per_codigo = emp_per_codigo;
	}

	/**
	 * Este metodo retorna el codigo del sitio alterno
	 * 
	 * @return
	 */
	public SitioAlterno getSitio_alterno_codigo() {
		return sitio_alterno_codigo;
	}

	/**
	 * Este metodo recibe el codigo del sitio alterno
	 * 
	 * @param sitio_alterno_codigo
	 */
	public void setSitio_alterno_codigo(SitioAlterno sitio_alterno_codigo) {
		this.sitio_alterno_codigo = sitio_alterno_codigo;
	}

	@Override
	public String toString() {
		return "Actividades [codigo=" + codigo + ", nombre=" + nombre + ", nivel=" + nivel + ", tiempo=" + tiempo + "]";
	}

}
