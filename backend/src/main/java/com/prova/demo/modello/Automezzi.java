package com.prova.demo.modello;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Automezzi")
public class Automezzi {

	@Id
	private @NotBlank String targa;
	private @NotBlank String tipologia;
	private @NotBlank String marca;
	@JsonIgnore
	@ManyToMany
	private List<ModelloA> modelliA;
	@JsonIgnore
	@ManyToMany
	private List<Registrazione> registrazioni;
}