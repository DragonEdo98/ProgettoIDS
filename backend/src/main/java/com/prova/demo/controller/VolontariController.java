package com.prova.demo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolontariController {

	private final VolontarioRepository volontarioRepository;

	public VolontariController(VolontarioRepository volrepository) {
		volontarioRepository = volrepository;
	}

	@PostMapping("/volontario/registrazione")
	public Volontario nuovoVolontario(@Validated @RequestBody Volontario nuovoVolontario) {
		return volontarioRepository.save(nuovoVolontario);
	}

	@GetMapping("/volontario/{codice}")
	public Volontario getVolontario(@PathVariable(name = "codice", required = true) Long codice) {
		Optional<Volontario> volontarioOptional = volontarioRepository.findById(codice);

		// controllo se un volontario esiste nel sistema
		if (!(volontarioOptional.isPresent()))
			throw new EntityNotFoundException("Il volontario non è stato trovato");
		return volontarioOptional.get();

	}
}
