package ups.edu.ec.clase.serviceRest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ups.edu.ec.clase.PM;
import ups.edu.ec.clase.Persona;
import ups.edu.ec.clase.PersonaMostrar;
import ups.edu.ec.clase.service.PersonaService;

@Path("/personas")

public class PersonaServiceRest  {
	
	@Inject
	private PersonaService pServicio;
	
	
	@GET
	@Path("/listPersonaEmpresa")
	@Produces("application/json")
	public List<PersonaMostrar> getPersonaMostrar(@QueryParam("cedula")String cedula){
		
		return pServicio.PersonaMostrar(cedula);
	}
	
	@GET
	@Path("/mostrarPersona")
	@Produces("application/json")
	public List<PM> getMostrar(@QueryParam("contrasena") String contrasena,@QueryParam("email") String email){
		
		return pServicio.Mostrar(contrasena,email);
	}

	
	
	@POST
	@Path("/insertPersona")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertarPersona(Persona persona) {
		
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		data.put("code", "1");
		data.put("message", "OK");
		builder = Response.status(Response.Status.OK).entity(data);
		
		try {
			pServicio.registrar(persona);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		
	return builder.build();	
	}


	@PUT
	@Path("/updatePersona")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizar(Persona p) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			pServicio.actualizar(p);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}


}