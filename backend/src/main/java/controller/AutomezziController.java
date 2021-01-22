package controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modello.Automezzi;
import repositoryInterface.AutomezziRepository;

@RestController
public class AutomezziController {
	
private final AutomezziRepository automezziRepository;

public AutomezziController(AutomezziRepository automRepository) {
	automezziRepository = automRepository;
}

@PostMapping("/registrazione")
public Automezzi nuovoAutomezzo(@Validated @RequestBody Automezzi nuovoAutomezzo) {
	return automezziRepository.save(nuovoAutomezzo);
}



public Automezzi getAutomezzo(String targa) {
	
	Optional<Automezzi> automezziOptional = automezziRepository.findById(targa);
	//controllo se un automezzo esiste nel sistema
	if(!(automezziOptional.isPresent()))
		throw new EntityNotFoundException("Il mezzo non è presente nel sistema");
	return automezziOptional.get();
}



}
