package com.prova.demo.modello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Firma")
public class FirmaGenerale {
	// @NotBlank controlliamo che l'attributo non sia ne nullo ne con spazio bianco
	// in fase di creazione

	@Id
	private String codiceFiscale;
	private @NotBlank String nome;
	private @NotBlank String cognome;
	private @NotBlank String enteAppartenenza;
	private @NotBlank String qualifica;

}
