package modello;

import java.util.ArrayList;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Registrazione {
	
	private @Id @GeneratedValue @NotBlank Long codiceVoloWebOrg;
	private @NotBlank Long ripetiCodiceVoloWeb;
	private @NotBlank String nomeOrg;
	private @NotBlank ArrayList <Volontari> volontariOrg;
	private ArrayList <Automezzi> automezziOrg;
	private @NotBlank Volontari coordinatoreOrg;
	private @NotBlank String passwordVoloWeb;
	private @NotBlank String ripetiPassword;
	
	
	
	public Long getCodiceVoloWebOrg() {
		return codiceVoloWebOrg;
	}
	public void setCodiceVoloWebOrg(Long codiceVoloWebOrg) {
		this.codiceVoloWebOrg = codiceVoloWebOrg;
	}
	public String getNomeOrg() {
		return nomeOrg;
	}
	public void setNomeOrg(String nomeOrg) {
		this.nomeOrg = nomeOrg;
	}
	public ArrayList<Volontari> getVolontariOrg() {
		return volontariOrg;
	}
	public void setVolontariOrg(ArrayList<Volontari> volontariOrg) {
		this.volontariOrg = volontariOrg;
	}
	public ArrayList<Automezzi> getAutomezziOrg() {
		return automezziOrg;
	}
	public void setAutomezziOrg(ArrayList<Automezzi> automezziOrg) {
		this.automezziOrg = automezziOrg;
	}
	public Volontari getCoordinatoreOrg() {
		return coordinatoreOrg;
	}
	public void setCoordinatoreOrg(Volontari coordinatoreOrg) {
		this.coordinatoreOrg = coordinatoreOrg;
	}
	public String getPasswordVoloWeb() {
		return passwordVoloWeb;
	}
	public void setPasswordVoloWeb(String passwordVoloWeb) {
		this.passwordVoloWeb = passwordVoloWeb;
	}

	public Long getRipetiCodiceVoloWeb() {
		return ripetiCodiceVoloWeb;
	}

	public String getRipetiPassword() {
		return ripetiPassword;
	}
	
	
}







