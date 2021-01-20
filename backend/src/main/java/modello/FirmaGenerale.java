package modello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FirmaGenerale {

	
	private @Id @GeneratedValue String codiceFiscale;
	private @NotBlank String nome;
	private @NotBlank String cognome;
	private @NotBlank String enteAppartenenza;
	private @NotBlank String qualifica;
	
}
