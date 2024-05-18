package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	public static final String OUTPUT_DIREZIONE_INESISTENTE = "Direzione inesistente";
	public static final String OUTPUT_VAI_SENZA_DIREZIONE = "Dove Vuoi andare?\nDevi specificare una direzione";
	private String direzione;
	private IO io;



	@Override
	public void esegui(Partita partita) {
		if(direzione==null)
			if(io!=null)io.mostraMessaggio(OUTPUT_VAI_SENZA_DIREZIONE);
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			if(io!=null)io.mostraMessaggio(OUTPUT_DIREZIONE_INESISTENTE);
		else {
			partita.setStanzaCorrente(prossimaStanza);
		    int cfu = partita.getCfu();
			partita.setCfu(cfu--);
		}
		if(io!=null)io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
	@Override
	public String getParametro() {
		return direzione;
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public IO getIO() {
		return this.io;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
