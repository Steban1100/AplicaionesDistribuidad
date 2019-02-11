package ups.edu.ec.clase.serviceRest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ups.edu.ec.clase.ActividadMostrar;
import ups.edu.ec.clase.Actividades;
import ups.edu.ec.clase.PersonaMostrar;
import ups.edu.ec.clase.service.ActividadesNegocio;

@Path("/actividades")

public class ActividadServiceRest  {
	
	@Inject
	private ActividadesNegocio pServicio;
	
	
	@GET
	@Path("/listActividades")
	@Produces("application/json")
	public List<ActividadMostrar> getActividadMostrar(@QueryParam("emp_per_codigo")int emp_per_codigo){
		
		return pServicio.ActividadMostrar(emp_per_codigo);
	}
	
}
