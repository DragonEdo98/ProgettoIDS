package controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modello.Volontari;
import repositoryInterface.VolontariRepository;

@RestController
public class VolontariController {

	private final VolontariRepository volontariRepository;
	
	
	public VolontariController(VolontariRepository volrepository) {
		volontariRepository = volrepository;
	}
	
	@PostMapping("/registrazione")
	public Volontari nuovoVolontario(@Validated @RequestBody Volontari nuovoVolontario) {
		return volontariRepository.save(nuovoVolontario);
	}
	

	
	public Volontari getVolontario(Long codiceVoloWeb) {
		Optional<Volontari> volontarioOptional = volontariRepository.findById(codiceVoloWeb);
		
		//controllo se un volontario esiste nel sistema
		if(!(volontarioOptional.isPresent())) 
			throw new EntityNotFoundException("Il volontario non è stato trovato");
		return volontarioOptional.get();
			
		
	
	
     }
}

