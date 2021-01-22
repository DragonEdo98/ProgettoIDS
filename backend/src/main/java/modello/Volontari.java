package modello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Volontari {
private @Id @GeneratedValue Long codiceVoloWeb;
private @NotBlank String nome;
private @NotBlank String cognome;


public Long getCodiceVoloWeb() {
	return codiceVoloWeb;
}
public void setCodiceVoloWeb(Long codiceVoloWeb) {
	this.codiceVoloWeb = codiceVoloWeb;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}



}
