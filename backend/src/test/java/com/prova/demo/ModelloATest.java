package com.prova.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prova.demo.controller.ModelloAController;
import com.prova.demo.modello.Automezzi;
import com.prova.demo.modello.ModelloA;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.AutomezziRepository;
import com.prova.demo.repositoryInterface.ModelloARepository;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

@SpringBootTest(classes = ProgettoIdsApplication.class)
class ModelloATest {

	@Autowired
	private RegistrazioneRepository r;
	@Autowired
	private VolontarioRepository v;
	@Autowired
	private AutomezziRepository a;
	@Autowired
	private ModelloARepository m;
	@Autowired
	private ModelloAController mc;

	@Test
	void ModelloACreato() {
		Registrazione re = new Registrazione();
		ArrayList<Volontario> vol = new ArrayList<Volontario>();
		ArrayList<Automezzi> aut = new ArrayList<Automezzi>();
		re.setCodiceVoloWebOrg(9753L);
		re.setNomeOrg("pincopallino");
		re.setPasswordVoloWeb("password");
		Volontario org = Volontario.builder().codiceVoloWeb(4213L).nome("Sergio").cognome("Rossi").build();
		re.setCoordinatoreOrg(org);
		v.save(org);
		vol.add(v.save(Volontario.builder().codiceVoloWeb(3344L).nome("Lorenzo").cognome("Binni").build()));
		vol.add(v.save(Volontario.builder().codiceVoloWeb(6778L).nome("Ugo").cognome("Scotti").build()));
		aut.add(a.save(Automezzi.builder().targa("TV345OP").marca("Ford").tipologia("Maccina").build()));
		r.save(re);

		ModelloA mod = new ModelloA();
		mod.setLuogoEvento("Casa tua");
		mod.setDataArrivoEvento(LocalDate.now());
		mod.setOrarioArrivoEvento(LocalTime.of(10, 00));
		mod.setTipoEvento("Festa");
		mod.setVolontariImpiegati(Arrays.asList(v.findById(3344L).get(), v.findById(4213L).get()));
		mod.setAutomezziImpiegati(Arrays.asList(a.findById("TV345OP").get()));
		mod.setNote("La festa era bellissima");
		mc.nuovoModello(mod);
		assertEquals(true, m.findById(mod.getCodiceId()).isPresent());
	}

	@Test
	void ModificaNotaModelloA() {
		Registrazione re2 = new Registrazione();
		ArrayList<Volontario> vol = new ArrayList<Volontario>();
		ArrayList<Automezzi> aut = new ArrayList<Automezzi>();
		re2.setCodiceVoloWebOrg(5555L);
		re2.setNomeOrg("pallino");
		re2.setPasswordVoloWeb("pass");
		Volontario org = Volontario.builder().codiceVoloWeb(4213L).nome("Luca").cognome("Verdi").build();
		re2.setCoordinatoreOrg(org);
		v.save(org);
		vol.add(v.save(Volontario.builder().codiceVoloWeb(3344L).nome("Marco").cognome("Pipo").build()));
		vol.add(v.save(Volontario.builder().codiceVoloWeb(6778L).nome("Giulia").cognome("Viola").build()));
		aut.add(a.save(Automezzi.builder().targa("TV345OP").marca("Maggiolino").tipologia("Macchina").build()));
		r.save(re2);

		ModelloA mod2 = new ModelloA();
		mod2.setLuogoEvento("Comune");
		mod2.setDataArrivoEvento(LocalDate.now());
		mod2.setOrarioArrivoEvento(LocalTime.of(10, 00));
		mod2.setTipoEvento("Elezioni");
		mod2.setVolontariImpiegati(Arrays.asList(v.findById(3344L).get(), v.findById(4213L).get()));
		mod2.setAutomezziImpiegati(Arrays.asList(a.findById("TV345OP").get()));
		mod2.setNote("Il sindaco");
		mc.nuovoModello(mod2);

		ModelloA mod3 = new ModelloA();
		mod3.setLuogoEvento(mod2.getLuogoEvento());
		mod3.setDataArrivoEvento(mod2.getDataArrivoEvento());
		mod3.setOrarioArrivoEvento(mod2.getOrarioArrivoEvento());
		mod3.setTipoEvento(mod2.getTipoEvento());
		mod3.setVolontariImpiegati(mod2.getVolontariImpiegati());
		mod3.setAutomezziImpiegati(mod2.getAutomezziImpiegati());
		mod3.setNote("Il sindaco ha fatto un disocrso molto lungo");

		mc.aggiornaModelloA(mod2, mod3);

		assertEquals("Il sindaco ha fatto un disocrso molto lungo", mod2.getNote());

	}

}
