package com.prova.demo.modello;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ModelloA")
public class ModelloA {

	@Id
	// Generiamo gli id dei modelli proceduralmente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceId;
	// @NotBlank controlliamo che l'attributo non sia ne nullo ne con spazio bianco
	// in fase di creazione
	// @NotNull controlliamo che l'atrributo non sia nullo in fase di creazione
	// @NotEmpty controlliamo che la lista non deve essere vuota in fase di
	// creazione
	private @NotBlank String tipoEvento;
	private @NotBlank String luogoEvento;
	private @NotNull LocalTime orarioArrivoEvento;
	private @NotNull LocalDate dataArrivoEvento;
	@ManyToMany(mappedBy = "modelliA")
	private @NotEmpty List<Volontario> volontariImpiegati;
	@ManyToMany(mappedBy = "modelliA")
	private @NotEmpty List<Automezzi> automezziImpiegati;
	private String note;
}