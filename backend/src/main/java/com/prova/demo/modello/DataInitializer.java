package com.prova.demo.modello;

import java.util.Arrays;

import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RegistrazioneRepository registrazioneRepository;

    @Autowired
    private VolontarioRepository volontarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Volontario vol = this.volontarioRepository.save(Volontario.builder().codiceVoloWeb(105L).nome("Mario").cognome("Rossi").build());
        Volontario vol2 = this.volontarioRepository.save(Volontario.builder().codiceVoloWeb(105L).nome("Signor").cognome("Bianchi").build());
        Volontario vol3 = this.volontarioRepository.save(Volontario.builder().codiceVoloWeb(105L).nome("Famiglia").cognome("Verdi").build());
        this.registrazioneRepository.save(Registrazione.builder().codiceVoloWebOrg(105L).passwordVoloWeb("password1").nomeOrg("Org").volontariOrg(Arrays.asList(vol, vol2)).coordinatoreOrg(vol3).build());
    }
}
