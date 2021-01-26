package com.prova.demo.controller;

import com.prova.demo.modello.ModelloA;
import com.prova.demo.repositoryInterface.ModelloARepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelloAController {

	private final ModelloARepository modelloARepository;

	public ModelloAController(ModelloARepository repository) {
		modelloARepository = repository;
	}

	@GetMapping("/menu")
	public Iterable<ModelloA> getModelloA() {
		return modelloARepository.findAll();
	}

	@PostMapping("/menu")
	public ModelloA nuovoModello(@Validated @RequestBody ModelloA nuovoModello) {
		return modelloARepository.save(nuovoModello);
	}

	@GetMapping("/menu/{codiceID}")
	public ModelloA modelloSingolo(@PathVariable(name = "codiceID", required = true) Long codiceId) {
		return modelloARepository.findById(codiceId).orElseThrow();
	}

}
