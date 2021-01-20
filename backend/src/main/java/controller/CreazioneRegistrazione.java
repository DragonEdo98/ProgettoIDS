package controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import modello.Registrazione;

@NoArgsConstructor
@AllArgsConstructor
public class CreazioneRegistrazione {
	
	private Registrazione reg;
	
	
	
public boolean ControlloCodiceVoloWeb () {
	
	if (reg.getCodiceVoloWebOrg() == reg.getRipetiCodiceVoloWeb()) {
		return true;
		
	}else {
		throw new IllegalArgumentException("I codici volo web non sono uguali");
	}
}
	
	public boolean ControlloPasswordVoloWeb() {
		if (reg.getPasswordVoloWeb() == reg.getRipetiPassword()) {
			return true;
		}else {
			throw new IllegalArgumentException("Le password non sono uguali");
		}
	}
	
	
	public Registrazione BuildRegistrazione() {
		if(ControlloCodiceVoloWeb() && ControlloPasswordVoloWeb()) {
			reg.setCodiceVoloWebOrg(reg.getCodiceVoloWebOrg());
			reg.setPasswordVoloWeb(reg.getPasswordVoloWeb());
			reg.setVolontariOrg(reg.getVolontariOrg());
			reg.setAutomezziOrg(reg.getAutomezziOrg());
			reg.setCoordinatoreOrg(reg.getCoordinatoreOrg());
			reg.setNomeOrg(reg.getNomeOrg());
			return reg;
		}else {
				throw new IllegalArgumentException("I dati non sono stati tutti inseriti o sono errati");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
	


