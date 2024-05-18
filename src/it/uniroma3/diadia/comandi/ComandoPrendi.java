package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	public static final String OUTPUT_PRENDI_SENZA_SUCCESSO = "Oggetto non presente";
	public static final String OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA = "L'attrezzo � stato preso e messo nello zaino";
	private String attrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		
		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
					if(partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					if(io!=null)io.mostraMessaggio(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA );
					
					}
			else
				if(io!=null)io.mostraMessaggio("Spiacente ma la borsa � piena");}
			}
		else 
			if(io!=null)io.mostraMessaggio(OUTPUT_PRENDI_SENZA_SUCCESSO);
		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo= parametro;
		
	}

	@Override
	public String getParametro() {
		return attrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
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
