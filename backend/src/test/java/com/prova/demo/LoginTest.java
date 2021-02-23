package com.prova.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;

import com.prova.demo.controller.LoginController;
import com.prova.demo.modello.Login;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.modello.Registrazione;
import com.prova.demo.modello.Volontario;
import com.prova.demo.repositoryInterface.RegistrazioneRepository;
import com.prova.demo.repositoryInterface.VolontarioRepository;

@SpringBootTest(classes = ProgettoIdsApplication.class)
class LoginTest {

	@Autowired
	private RegistrazioneRepository r;
	@Autowired
	private VolontarioRepository volrep;
	@Autowired
	private LoginController l;

	@Test
	void AccessoEffettuato() {
		Registrazione regi = new Registrazione();
		ArrayList<Volontario> volo = new ArrayList<Volontario>();
		regi.setCodiceVoloWebOrg(1122L);
		regi.setNomeOrg("PizzaPazza");
		regi.setPasswordVoloWeb("lalala");
		Volontario organ = Volontario.builder().codiceVoloWeb(9999L).nome("Tito").cognome("Sasso").build();
		regi.setCoordinatoreOrg(volrep.save(Volontario.builder().codiceVoloWeb(2211L).nome("Gianni").cognome("Lopez").build()));
		volo.add(volrep.save(Volontario.builder().codiceVoloWeb(3344L).nome("Tina").cognome("Cant").build()));
		regi.setCoordinatoreOrg(organ);
		volo.add(volrep.save(organ));
		r.save(regi);
		Login log = new Login();
		log.setCodiceVoloWebLogin(1122L);
		log.setPasswordLogin("lalala");

		assertEquals(true, l.accediNormalmente(log));
	}

	@Test
	void LoginEntityNotFound() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			Login log2 = new Login();
			log2.setCodiceVoloWebLogin(9876L);
			log2.setPasswordLogin("pinco");
			l.accediNormalmente(log2);

		});

	}

	@Test
	void LoginPasswordSbagliata() {
		Assertions.assertThrows(BadCredentialsException.class, () -> {
			Login log3 = new Login();
			log3.setCodiceVoloWebLogin(1122L);
			log3.setPasswordLogin("laal");
			l.accediNormalmente(log3);
		});
	}

	@Test
	void AccessoAdmin() {
		Login log4 = new Login();
		log4.setCodiceVoloWebLogin(0L);
		log4.setPasswordLogin("admin");
		assertEquals(true, l.accediComeAdmin(log4));
	}
}
