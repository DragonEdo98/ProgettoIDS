package com.prova.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.controller.RegistrazioneController;
import com.prova.demo.modello.Automezzi;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.AutomezziRepository;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest(classes = ProgettoIdsApplication.class)
public class RegistrazioneTests {

    @Autowired
    private RegistrazioneRepository y;
    @Autowired
    private VolontarioRepository v;
    @Autowired
    private AutomezziRepository a;
    @Autowired
    private RegistrazioneController c;

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

    @Test
    public void RegistrazioneNonTrovata() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            Registrazione reg3 = new Registrazione();
            reg3.setCodiceVoloWebOrg(3456L);
            ArrayList<Volontario> vol = new ArrayList<Volontario>();
            ArrayList<Automezzi> aut = new ArrayList<Automezzi>();
            Volontario org = Volontario.builder().codiceVoloWeb(3333L).nome("Vero").cognome("Falso").build();
            reg3.setNomeOrg("pippo");
            reg3.setPasswordVoloWeb("pluto");
            vol.add(v.save(Volontario.builder().codiceVoloWeb(2222L).nome("Paolo").cognome("Paolini").build()));
            vol.add(v.save(Volontario.builder().codiceVoloWeb(1111L).nome("Mario").cognome("Rossi").build()));
            reg3.setCoordinatoreOrg(org);
            vol.add(v.save(org));
            reg3.setVolontariOrg(vol);
            aut.add(a.save(Automezzi.builder().targa("GX234DD").tipologia("Macchina").marca("Fiat").build()));
            reg3.setAutomezziOrg(aut);
            c.RegistrazioneTrovata(reg3);
        });
    }

    @Test
    public void CancellazioneRegistrazione() {
        Registrazione reg4 = new Registrazione();
        reg4.setCodiceVoloWebOrg(3456L);
        ArrayList<Volontario> vol = new ArrayList<Volontario>();
        ArrayList<Automezzi> aut = new ArrayList<Automezzi>();
        Volontario org = Volontario.builder().codiceVoloWeb(9996L).nome("Leo").cognome("Poldo").build();
        reg4.setNomeOrg("PlutoOrg");
        reg4.setPasswordVoloWeb("sassari");
        vol.add(v.save(Volontario.builder().codiceVoloWeb(4765L).nome("Luigi").cognome("Rossi").build()));
        vol.add(v.save(Volontario.builder().codiceVoloWeb(3955L).nome("Lucia").cognome("Viola").build()));
        reg4.setCoordinatoreOrg(org);
        vol.add(v.save(org));
        reg4.setVolontariOrg(vol);
        aut.add(a.save(Automezzi.builder().targa("VC435FD").tipologia("Furgone").marca("Volvo").build()));
        reg4.setAutomezziOrg(aut);
        y.save(reg4);
        y.delete(reg4);
        assertEquals(false, y.findById(reg4.getCodiceVoloWebOrg()).isPresent());

    }

}
