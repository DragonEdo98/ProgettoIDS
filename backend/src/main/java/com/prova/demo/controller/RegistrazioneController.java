package com.prova.demo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.prova.demo.modello.Registrazione;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrazioneController {

	private final RegistrazioneRepository registrazioneRepository;

	public RegistrazioneController(RegistrazioneRepository regRepository) {
		registrazioneRepository = regRepository;
	}

	// Salviamo una nuova registrazione nella repository
	@PostMapping("/nuovaregistrazione")
	public Registrazione nuovaRegistrazione(@Valid @RequestBody Registrazione nuovaRegistrazione) {
		return registrazioneRepository.save(nuovaRegistrazione);
	}

	// Troviamo una registrazione creata all'interno del sistema altrimenti
	// eccezione EntityNotFoundException
	@PostMapping("/registrazione/{codiceVoloWebOrg}")
	public Registrazione RegistrazioneTrovata(@Valid Registrazione reg) {
		Optional<Registrazione> registrazioneOptional = registrazioneRepository.findById(reg.getCodiceVoloWebOrg());

		if (!(registrazioneOptional.isPresent())) {
			throw new EntityNotFoundException(
					"L'organizzazione con il codices" + reg.getCodiceVoloWebOrg() + "non è presente nel sistema");
		}
		return reg;
	}

	// Cancelliamo una registrazione presente nel sistema
	@DeleteMapping("/menuAdmin/eliminaOrg/{codiceVoloWebOrg}")
	public ResponseEntity<Registrazione> cancellaRegistrazione(@PathVariable(value = "id") Long codiceVoloWebOrg) {
		Registrazione regist = registrazioneRepository.findById(codiceVoloWebOrg).orElseThrow();
		registrazioneRepository.delete(regist);
		return ResponseEntity.ok().build();
	}

}
