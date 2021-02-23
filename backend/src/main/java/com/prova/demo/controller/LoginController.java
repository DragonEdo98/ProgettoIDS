package com.prova.demo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prova.demo.modello.Login;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;

@RestController
public class LoginController {

	private final RegistrazioneRepository registrazioneRepository;

	public LoginController(RegistrazioneRepository reg) {
		registrazioneRepository = reg;

	}

	// Verifichiamo che le crendenziali per il login corrispondano ad una
	// registrazione presente nel sistema
	@PostMapping("/login")
	public boolean accediNormalmente(@Valid @RequestBody Login credenziali) {

		Optional<Registrazione> registrazioneOptional = registrazioneRepository
				.findById(credenziali.getCodiceVoloWebLogin());
		// controllo se una registrazione esiste nel sistema
		if (!(registrazioneOptional.isPresent()))
			throw new EntityNotFoundException("L'organizzazione con il codices" + credenziali.getCodiceVoloWebLogin()
					+ "non è presente nel sistema");

		if (!registrazioneOptional.get().getPasswordVoloWeb().equals(credenziali.getPasswordLogin())) {
			throw new BadCredentialsException("Coppia ID Volo Web/password errati!");
		}

		return true;
	}

	// Verificaimo l'accesso per l'admin con credenziali di defoult
	@PostMapping("/accessoadmin")
	public boolean accediComeAdmin(@Valid @RequestBody Login credenziali) {
		return credenziali.getCodiceVoloWebLogin() == 0 && credenziali.getPasswordLogin().equals("admin");
	}

}
