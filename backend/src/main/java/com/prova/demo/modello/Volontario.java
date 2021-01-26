package com.prova.demo.modello;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "Volontari")
public class Volontario {
	@Id
	@Column(name = "id")
	private Long codiceVoloWeb;
	private @NotBlank String nome;
	private @NotBlank String cognome;
	@JsonIgnore
	@ManyToMany
	private List<ModelloA> modelliA;
	@JsonIgnore
	@ManyToMany
	private List<Registrazione> registrazioni;
	@JsonIgnore
	@OneToMany(mappedBy = "coordinatoreOrg")
	private List<Registrazione> coordinatoreReigstrazioni;
}
