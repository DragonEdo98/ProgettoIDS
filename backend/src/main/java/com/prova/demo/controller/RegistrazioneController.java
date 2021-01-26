package com.prova.demo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.modello.Login;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrazioneController {

	private final RegistrazioneRepository registrazioneRepository;

	public RegistrazioneController(RegistrazioneRepository regRepository) {
		registrazioneRepository = regRepository;
	}

	@PostMapping("/nuovaregistrazione")
	public Registrazione nuovaRegistrazione(@Validated @RequestBody Registrazione nuovaRegistrazione) {
		return registrazioneRepository.save(nuovaRegistrazione);
	}

	@PostMapping("/registrazione")
	public Registrazione accediNormalmente(@Validated @RequestBody Login credenziali) {

		Optional<Registrazione> registrazioneOptional = registrazioneRepository.findById(credenziali.getCodiceVoloWebLogin());
		// controllo se una registrazione esiste nel sistema
		if (!(registrazioneOptional.isPresent()))
			throw new EntityNotFoundException(
					"L'organizzazione con il codices" + credenziali.getCodiceVoloWebLogin() + "non è presente nel sistema");

		if (!registrazioneOptional.get().getPasswordVoloWeb().equals(credenziali.getPasswordLogin())) {
			throw new BadCredentialsException("Coppia ID Volo Web/password errati!");
		}

		return registrazioneOptional.get();
	}

	@PostMapping("/accessoadmin")
	public boolean accediComeAdmin(@Validated @RequestBody Login credenziali) {
		return credenziali.getCodiceVoloWebLogin() == 0 && credenziali.getPasswordLogin().equals("admin");
	}
}
