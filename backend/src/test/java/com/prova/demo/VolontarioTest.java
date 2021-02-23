package com.prova.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.controller.VolontariController;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProgettoIdsApplication.class)

public class VolontarioTest {

    @Autowired
    private RegistrazioneRepository y;
    @Autowired
    private VolontarioRepository v;
    @Autowired
    private VolontariController vc;

    @Test
    public void VolontarioTrovato() {
        Registrazione regist = new Registrazione();
        ArrayList<Volontario> volont = new ArrayList<Volontario>();
        Volontario organ = Volontario.builder().codiceVoloWeb(7343L).nome("Simone").cognome("Silver").build();
        regist.setCodiceVoloWebOrg(4533L);
        regist.setNomeOrg("Luppolo");
        regist.setPasswordVoloWeb("birra");
        volont.add(v.save(Volontario.builder().codiceVoloWeb(7465L).nome("Jojo").cognome("Giovanna").build()));
        volont.add(v.save(Volontario.builder().codiceVoloWeb(3846L).nome("Eren").cognome("Mikasa").build()));
        regist.setCoordinatoreOrg(organ);
        volont.add(v.save(organ));
        regist.setVolontariOrg(volont);
        y.save(regist);

        assertEquals(true, v.findById(7465L).isPresent());

    }

    @Test
    public void VolontarioNonTrovato() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            Registrazione regist2 = new Registrazione();
            ArrayList<Volontario> volont = new ArrayList<Volontario>();
            Volontario organ = Volontario.builder().codiceVoloWeb(3445L).nome("Simone").cognome("Silver").build();
            regist2.setCodiceVoloWebOrg(5665L);
            regist2.setNomeOrg("Luppolo");
            regist2.setPasswordVoloWeb("birra");
            volont.add(v.save(Volontario.builder().codiceVoloWeb(9008L).nome("Jojo").cognome("Giovanna").build()));
            volont.add(v.save(Volontario.builder().codiceVoloWeb(7564L).nome("Eren").cognome("Mikasa").build()));
            regist2.setCoordinatoreOrg(organ);
            volont.add(v.save(organ));
            regist2.setVolontariOrg(volont);
            y.save(regist2);
            vc.getVolontario(1111L);
        });
    }

}
