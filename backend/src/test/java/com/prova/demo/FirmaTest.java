package com.prova.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prova.demo.controller.FirmaController;
import com.prova.demo.modello.FirmaGenerale;
import com.prova.demo.modello.ProgettoIdsApplication;
import com.prova.demo.repositoryInterface.FirmaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProgettoIdsApplication.class)
public class FirmaTest {

    @Autowired
    private FirmaRepository f;
    @Autowired
    private FirmaController c;

    @Test
    void FirmaCreata() {

        FirmaGenerale fg = FirmaGenerale.builder().codiceFiscale("TRP34Y56L654P").nome("Tiro").cognome("Assegno")
                .enteAppartenenza("Polizia").qualifica("Maresciallo").build();
        c.nuovaFirma(fg);
        assertEquals(true, f.existsById(fg.getCodiceFiscale()));

    }

}
