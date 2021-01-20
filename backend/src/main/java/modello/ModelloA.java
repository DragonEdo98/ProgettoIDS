package modello;

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
	private @NotBlank LocalDateTime orarioArrivoEvento;
	private @NotBlank Date dataArrivoEvento;
	private @NotBlank ArrayList<Volontari> volontariImpiegati;
	private ArrayList<Automezzi> automezziImpiegati;
	private String note;
	
	
	
	public Long getCodiceId() {
		return codiceId;
	}
	public void setCodiceId(Long codiceId) {
		this.codiceId = codiceId;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getLuogoEvento() {
		return luogoEvento;
	}
	public void setLuogoEvento(String luogoEvento) {
		this.luogoEvento = luogoEvento;
	}
	public LocalDateTime getOrarioArrivoEvento() {
		return orarioArrivoEvento;
	}
	public void setOrarioArrivoEvento(LocalDateTime orarioArrivoEvento) {
		this.orarioArrivoEvento = orarioArrivoEvento;
	}
	public Date getDataArrivoEvento() {
		return dataArrivoEvento;
	}
	public void setDataArrivoEvento(Date dataArrivoEvento) {
		this.dataArrivoEvento = dataArrivoEvento;
	}
	public ArrayList<Volontari> getVolontariImpiegati() {
		return volontariImpiegati;
	}
	public void setVolontariImpiegati(ArrayList<Volontari> volontariImpiegati) {
		this.volontariImpiegati = volontariImpiegati;
	}
	public ArrayList<Automezzi> getAutomezziImpiegati() {
		return automezziImpiegati;
	}
	public void setAutomezziImpiegati(ArrayList<Automezzi> automezziImpiegati) {
		this.automezziImpiegati = automezziImpiegati;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}