package com.prova.demo.controller;

import javax.validation.Valid;

import com.prova.demo.modello.FirmaGenerale;
import com.prova.demo.repositoryInterface.FirmaRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirmaController {

	private final FirmaRepository firmaRepository;

	public FirmaController(FirmaRepository firmaRep) {
		firmaRepository = firmaRep;
	}

	// Salviammo nella repository una nuova firma creata
	@PostMapping("/menu/richiestaFirma")
	public FirmaGenerale nuovaFirma(@Valid @RequestBody FirmaGenerale nuovaFirma) {
		return firmaRepository.save(nuovaFirma);
	}

}
