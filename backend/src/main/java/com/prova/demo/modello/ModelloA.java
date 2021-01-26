package com.prova.demo.modello;

import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	@GeneratedValue
	private Long codiceId;
	private @NotBlank String tipoEvento;
	private @NotBlank String luogoEvento;
	private @NotBlank LocalDateTime orarioArrivoEvento;
	private @NotBlank Date dataArrivoEvento;
	@ManyToMany(mappedBy = "modelliA")
	private @NotBlank List<Volontario> volontariImpiegati;
	@ManyToMany(mappedBy = "modelliA")
	private @NotBlank List<Automezzi> automezziImpiegati;
	private String note;
	
	
	public String getLuogoEvento() {
		return luogoEvento;
	}
	public Date getDataArrivoEvento() {
		return dataArrivoEvento;
	}
	public LocalDateTime getOrarioArrivoEvento() {
		return orarioArrivoEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public List<Automezzi> getAutomezziImpiegati() {
		return automezziImpiegati;
	}
	public Date setDataArrivoEvento(Date dataArrivoEvento) {
		return dataArrivoEvento;
		
	}
	
	@NotBlank 
	public String setLuogoEvento(String luogoEvento) {
		return luogoEvento;
	}
	
	public List<Automezzi> setAutomezziImpiegati(List<Automezzi> automezziImpiegati) {
		return automezziImpiegati;
	}
	public List<Volontario> getVolontariImpiegati() {
		return volontariImpiegati;
	}
	
	
	public List<Volontario> setVolontariImpiegati(List<Volontario> volontariImpiegati) {
		return volontariImpiegati;
	}
	public String getNote() {
		return note;
	}
	public String setNote(String note) {
		return note;
	}
	public LocalDateTime setOrarioArrivoEvento(LocalDateTime orarioArrivoEvento) {
		return orarioArrivoEvento;
	}
	public String setTipoEvento(String tipoEvento) {
		return tipoEvento;
	}

}