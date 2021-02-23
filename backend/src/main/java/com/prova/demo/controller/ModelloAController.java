package com.prova.demo.controller;

import com.prova.demo.modello.ModelloA;
import com.prova.demo.repositoryInterface.ModelloARepository;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelloAController {

	private final ModelloARepository modelloARepository;

	public ModelloAController(ModelloARepository repository) {
		modelloARepository = repository;
	}

	// Prendiamo tutti i modelliA creati
	@GetMapping("/menu/all")
	public Iterable<ModelloA> getModelloA() {
		return modelloARepository.findAll();
	}

	// Salviamo un nuovo modello creato nella repository
	@PostMapping("/menu")
	public ModelloA nuovoModello(@Valid @RequestBody ModelloA nuovoModello) {
		return modelloARepository.save(nuovoModello);

	}

	// Cerchiamo un modello specifico attraverso il suo id
	@GetMapping("/menu/{codiceID}")
	public ModelloA modelloSingolo(@PathVariable(name = "codiceID", required = true) Long codiceId) {
		return modelloARepository.findById(codiceId).orElseThrow();
	}

	// Controlliamo se un modello esiste nel sistema
	@PostMapping("/menu/modelloATrovato")
	public ModelloA modelloATrovato(@Valid ModelloA modelloATrovato) {
		Optional<ModelloA> modelloAOptional = modelloARepository.findById(modelloATrovato.getCodiceId());

		if (!(modelloAOptional.isPresent())) {
			throw new EntityNotFoundException(
					"Il modello con il codice" + modelloATrovato.getCodiceId() + "non è presente nel sistema");

		}
		return modelloATrovato;
	}

	// Modifichiamo l'attributo note riaggiornando il modelloA a cui viene fatta la
	// modifica
	@PutMapping("/menu/modelloAModifica/{codiceId}")
	public ModelloA aggiornaModelloA(@RequestBody @Valid ModelloA model, @RequestBody @Valid ModelloA modelMod) {
		model.setNote(modelMod.getNote());
		return modelloARepository.save(model);

	}

}
