package com.prova.demo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.modello.Automezzi;
import com.prova.demo.repositoryInterface.AutomezziRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutomezziController {

	private final AutomezziRepository automezziRepository;

	public AutomezziController(AutomezziRepository automRepository) {
		automezziRepository = automRepository;
	}

	@PostMapping("/automezzi/registrazione")
	public Automezzi nuovoAutomezzo(@Validated @RequestBody Automezzi nuovoAutomezzo) {
		return automezziRepository.save(nuovoAutomezzo);
	}

	@GetMapping("/automezzi/{targa}")
	public Automezzi getAutomezzo(@PathVariable(name = "targa", required = true) String targa) {

		Optional<Automezzi> automezziOptional = automezziRepository.findById(targa);
		// controllo se un automezzo esiste nel sistema
		if (!(automezziOptional.isPresent()))
			throw new EntityNotFoundException("Il mezzo non è presente nel sistema");
		return automezziOptional.get();
	}

}
