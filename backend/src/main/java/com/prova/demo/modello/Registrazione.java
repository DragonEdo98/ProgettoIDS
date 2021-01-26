package com.prova.demo.modello;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Registrazione")
public class Registrazione {

	@Id
	@NotNull
	private Long codiceVoloWebOrg;
	@NotBlank
	private String nomeOrg;
	@JsonIgnore
	@ManyToMany(mappedBy = "registrazioni")
	private List<Volontario> volontariOrg;
	@JsonIgnore
	@ManyToMany(mappedBy = "registrazioni")
	private List<Automezzi> automezziOrg;
	@JsonIgnore
	@ManyToOne
	private Volontario coordinatoreOrg;
	@NotBlank
	private String passwordVoloWeb;
}
