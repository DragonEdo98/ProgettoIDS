package com.prova.demo;

import java.util.ArrayList;
import java.util.Date;
import java.time.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ModelloA {

	private @Id @GeneratedValue Long codiceId;
	private @NotBlank String tipoEvento;
	private @NotBlank String luogoEvento;
	private LocalDateTime orarioArrivoEvento;
	private Date dataArrivoEvento;
	private ArrayList<Volontari> volontariImpiegati;
	private ArrayList<Automezzi> automezziImpiegati;
	private String note;
	private @NotBlank String firmaResponsabileOrg;
}