package ups.edu.ec.clase.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.clase.Persona;
import ups.edu.ec.clase.Administrador;
import ups.edu.ec.clase.PM;
import ups.edu.ec.clase.dao.AdministradorDao;
import ups.edu.ec.clase.dao.LoginDao;
import ups.edu.ec.clase.dao.PersonaDAO;


@Stateless
public class LoginBussiness {

	@Inject
	private  LoginDao  logDao;
	private AdministradorDao perdao;
	
	public String Logueo (String email, String contrasena) {
		Administrador adulto = logDao.BuscarLog(email,contrasena);
		System.out.println("logueo Busines "+adulto);
		if(adulto !=null) 
			return "si";
		else
		return "no";
	}
	
}