package controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modello.FirmaGenerale;
import repositoryInterface.FirmaRepository;

@RestController
public class FirmaController {

	private final FirmaRepository firmaRepository;
	
	public FirmaController (FirmaRepository firmaRep) {
		firmaRepository = firmaRep;
	}
	
	@PostMapping ("/menu/richiestaFirma")
	public FirmaGenerale nuovaFirma(@Validated @RequestBody FirmaGenerale nuovaFirma) {
		return firmaRepository.save(nuovaFirma);
	} 
	
	
}
