package com.prova.demo.controller;

import com.prova.demo.modello.FirmaGenerale;
import com.prova.demo.repositoryInterface.FirmaRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirmaController {

	private final FirmaRepository firmaRepository;

	public FirmaController(FirmaRepository firmaRep) {
		firmaRepository = firmaRep;
	}

	@PostMapping("/menu/richiestaFirma")
	public FirmaGenerale nuovaFirma(@Validated @RequestBody FirmaGenerale nuovaFirma) {
		return firmaRepository.save(nuovaFirma);
	}

}
