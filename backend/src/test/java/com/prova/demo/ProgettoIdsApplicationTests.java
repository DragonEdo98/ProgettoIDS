package com.prova.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.prova.demo.modello.Automezzi;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.AutomezziRepository;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProgettoIdsApplication.class)
public class ProgettoIdsApplicationTests {

    @Autowired
    private RegistrazioneRepository y;
    @Autowired
    private VolontarioRepository v;
    @Autowired
    private AutomezziRepository a;

    @Test
    public void RegistrazioneEffettuata() {
        Registrazione reg = new Registrazione();
        ArrayList<Volontario> vol = new ArrayList<Volontario>();
        ArrayList<Automezzi> aut = new ArrayList<Automezzi>();
        Volontario org = Volontario.builder().codiceVoloWeb(3333L).nome("Vero").cognome("Falso").build();
        reg.setCodiceVoloWebOrg(1234L);
        reg.setNomeOrg("pippo");
        reg.setPasswordVoloWeb("pluto");
        vol.add(v.save(Volontario.builder().codiceVoloWeb(2222L).nome("Paolo").cognome("Paolini").build()));
        vol.add(v.save(Volontario.builder().codiceVoloWeb(1111L).nome("Mario").cognome("Rossi").build()));
        reg.setCoordinatoreOrg(org);
        vol.add(v.save(org));
        reg.setVolontariOrg(vol);
        aut.add(a.save(Automezzi.builder().targa("GX234DD").tipologia("Macchina").marca("Fiat").build()));
        reg.setAutomezziOrg(aut);
        y.save(reg);
        assertEquals(true, y.findById(reg.getCodiceVoloWebOrg()).isPresent());
    }
}
