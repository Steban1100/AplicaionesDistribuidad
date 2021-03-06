package ups.edu.ec.clase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Esta es una clase que nos crea la tabla del sitio altenro con todos sus
 * parametros
 * 
 * @author Esteban Solano - Marcos Cordova
 *
 */
@Entity
@Table(name = "tbl_sitio_alterno")
public class SitioAlterno {
	@Id
	@NotNull
	@Column(name = "sitio_alterno_codigo", length = 4)
	private int codigo;

	@NotNull
	@Column(name = "sitio_alterno_ubicacion")
	private String ubicacion;

	@NotNull
	@Column(name = "sitio_alterno_descripcion")
	private String descripcion;

	@NotNull
	@Column(name = "sitio_alterno_tamano")
	private String tamano;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "sitio_alterno_codigo")
	private Actividades propietarioActividad;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public Actividades getPropietarioActividad() {
		return propietarioActividad;
	}

	public void setPropietarioActividad(Actividades propietarioActividad) {
		this.propietarioActividad = propietarioActividad;
	}

	@Override
	public String toString() {
		return "SitioAlterno [codigo=" + codigo + ", ubicacion=" + ubicacion + ", descripcion=" + descripcion
				+ ", tamano=" + tamano + "]";
	}

}
