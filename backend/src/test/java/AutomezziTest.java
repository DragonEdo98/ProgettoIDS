
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import com.prova.demo.controller.AutomezziController;
import com.prova.demo.modello.Automezzi;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.AutomezziRepository;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProgettoIdsApplication.class)

public class AutomezziTest {

    @Autowired
    private AutomezziRepository ar;
    @Autowired
    private RegistrazioneRepository rr;
    @Autowired
    private VolontarioRepository vr;
    @Autowired
    private AutomezziController ac;

    @Test
    public void AutomezzoTrovato() {

        Registrazione regi = new Registrazione();
        ArrayList<Volontario> volo = new ArrayList<Volontario>();
        ArrayList<Automezzi> auto = new ArrayList<Automezzi>();
        Volontario org = Volontario.builder().codiceVoloWeb(3333L).nome("Vero").cognome("Falso").build();
        regi.setCodiceVoloWebOrg(1234L);
        regi.setNomeOrg("Topolino");
        regi.setPasswordVoloWeb("paperino");
        volo.add(vr.save(Volontario.builder().codiceVoloWeb(3245L).nome("Paolo").cognome("Paolini").build()));
        volo.add(vr.save(Volontario.builder().codiceVoloWeb(4572L).nome("Mario").cognome("Rossi").build()));
        regi.setCoordinatoreOrg(org);
        volo.add(vr.save(org));
        regi.setVolontariOrg(volo);
        auto.add(ar.save(Automezzi.builder().targa("LP765RF").tipologia("Macchina").marca("Ford").build()));
        regi.setAutomezziOrg(auto);
        rr.save(regi);

        assertEquals(true, ar.findById("LP765RF").isPresent());

    }

    @Test
    public void AutomezzoNonTrvato() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            Registrazione regi2 = new Registrazione();
            ArrayList<Volontario> volo = new ArrayList<Volontario>();
            ArrayList<Automezzi> auto = new ArrayList<Automezzi>();
            Volontario org = Volontario.builder().codiceVoloWeb(7676L).nome("Vero").cognome("Falso").build();
            regi2.setCodiceVoloWebOrg(1234L);
            regi2.setNomeOrg("Topolino");
            regi2.setPasswordVoloWeb("paperino");
            volo.add(vr.save(Volontario.builder().codiceVoloWeb(3245L).nome("Paolo").cognome("Paolini").build()));
            volo.add(vr.save(Volontario.builder().codiceVoloWeb(4572L).nome("Mario").cognome("Rossi").build()));
            regi2.setCoordinatoreOrg(org);
            volo.add(vr.save(org));
            regi2.setVolontariOrg(volo);
            auto.add(ar.save(Automezzi.builder().targa("LP765RF").tipologia("Macchina").marca("Ford").build()));
            regi2.setAutomezziOrg(auto);
            rr.save(regi2);
            ac.getAutomezzo("PO876TG");
        });
    }
}
