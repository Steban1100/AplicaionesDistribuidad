package ups.edu.ec.SOAP;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ups.edu.ec.clase.Persona;
import ups.edu.ec.clase.service.PersonaService;

@WebService
public class PersonaSOAP {

	@Inject
	private PersonaService pService;

	@WebMethod
	public List<Persona> getPersonas() {
		return pService.listarPersona();
	}

	@WebMethod
	public void agregarPersona(String cedula, String nombre, String celular, String email) {
		Persona p = new Persona();
		p.setCedula(cedula);
		p.setNombres(nombre);
		p.setCelular(celular);
		p.setEmail(email);

		try {
			pService.registrar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@WebMethod
	public void editarPersona(String cedula, String nombre, String celular, String email) {
		Persona pe = new Persona();
		pe.setCedula(cedula);
		pe.setNombres(nombre);
		pe.setCelular(celular);
		pe.setEmail(email);

		try {
			pService.actualizar(pe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
