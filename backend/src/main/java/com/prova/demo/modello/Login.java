package com.prova.demo.modello;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	// @NotNull controlliamo che l'atrributo non sia nullo in fase di creazione
	private @NotNull Long codiceVoloWebLogin;
	private @NotNull String passwordLogin;
}
