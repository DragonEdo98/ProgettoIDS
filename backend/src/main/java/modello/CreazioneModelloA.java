package modello;


public class CreazioneModelloA {

    private ModelloA mdla;


	public ModelloA setCreazioneModelloA() {
		if(mdla.getLuogoEvento() != null && mdla.getDataArrivoEvento() != null && mdla.getLuogoEvento() != null && mdla.getOrarioArrivoEvento() != null
				&& mdla.getTipoEvento() != null){
			mdla.setAutomezziImpiegati(mdla.getAutomezziImpiegati());
			mdla.setDataArrivoEvento(mdla.getDataArrivoEvento());
			mdla.setLuogoEvento(mdla.getLuogoEvento());
			mdla.setVolontariImpiegati(mdla.getVolontariImpiegati());
			mdla.setNote(mdla.getNote());
			mdla.setOrarioArrivoEvento(mdla.getOrarioArrivoEvento());
			mdla.setTipoEvento(mdla.getTipoEvento());
	       return mdla;
		} else {
			throw new IllegalArgumentException("I campi obbligatori * non sono stati tutti compilati.");
		}
		
	} 
		
	


}