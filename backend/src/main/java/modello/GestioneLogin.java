package modello;

import javax.persistence.EntityNotFoundException;

import controller.RegistrazioneController;



public class GestioneLogin {

	
	private RegistrazioneController reg;
	private Login login;
	
	public GestioneLogin(Login acc) {
		login = acc;
	}

public boolean ControlloAccesso() {
  Long log = reg.getRegistrazione(login.getCodiceVoloWebLogin()).getCodiceVoloWebOrg();
  String pas = reg.getRegistrazione(login.getCodiceVoloWebLogin()).getPasswordVoloWeb();
  if(login.getCodiceVoloWebLogin() == log && login.getPasswordLogin() == pas) {
	  return true;
  }else {
	  if(log == null || pas == null)
	  throw new EntityNotFoundException("ID o password errati");
  }
  return false;
		  
}

 public boolean AccessoAdmin() {
	 if(login.getCodiceVoloWebLogin()== 00000 && login.getPasswordLogin() == "admin" ) {
		 return true;
	 }else {
		 if(login.getCodiceVoloWebLogin()== 00000 && login.getPasswordLogin() != "admin" 
				 || login.getCodiceVoloWebLogin()!= 00000 && login.getPasswordLogin()=="admin" ) {
			 throw new EntityNotFoundException("Hai provato ad accedere come amministratore , Id o password errati");
		 }
	 
	 return false;
 }
	

 }	
}
