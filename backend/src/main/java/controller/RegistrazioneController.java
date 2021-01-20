package controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import modello.Registrazione;
import repositoryInterface.RegistrazioneRepository;

@RestController
public class RegistrazioneController {

	private final RegistrazioneRepository registrazioneRepository;
	
	public RegistrazioneController (RegistrazioneRepository regRepository) {
		
		registrazioneRepository = regRepository;
	}
	
	@PostMapping("/registrazione")
	public Registrazione nuovaRegistrazione(@Validated @RequestBody Registrazione nuovaRegistrazione) {
		return registrazioneRepository.save(nuovaRegistrazione);
	}
	
	
	public Registrazione getRegistrazione(Long codiceVoloWebOrg) {
		
		Optional<Registrazione> registrazioneOptional = registrazioneRepository.findById(codiceVoloWebOrg);
		//controllo se una registrazione esiste nel sistema
		if(!(registrazioneOptional.isPresent()))
			throw new EntityNotFoundException("L'organizzazione" +codiceVoloWebOrg+ "non è presente nel sistema");
		return registrazioneOptional.get();
		
	
	}	
}
