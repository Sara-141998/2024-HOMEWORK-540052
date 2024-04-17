package it.uniroma3.diadia;

import java.util.Scanner;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 * 
 */

public class DiaDia{

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai + <direzione>", "aiuto", "fine", "prendi + <nomeAttrezzo>", "posa + <nomeAttrezzo>"};

	private Partita partita;
	public static IOConsole iO;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		iO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione=iO.leggiRiga();}
		while(!processaIstruzione(istruzione));


	}

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco 
	 * ntinua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire = new Comando(istruzione);

		if(!istruzione.isEmpty()) {
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   
		return false;
}		
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 * 
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			iO.mostraMessaggio(elencoComandi[i]+" ");
		iO.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 * @param direzione
	 */
	private void vai(String direzione) {
		if(direzione==null)
			iO.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			iO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		iO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	/**
	 * Prende un attrezzo dalla stanza, lo copia nella borsa e poi lo rimuove dalla stanza
	 * 
	 * @return true se va tutto a buon fine altrimenti false con uno specifico messaggio di errore
	 */
	public boolean prendi(String attrezzo) {

		if(this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPreso=this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
					if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					iO.mostraMessaggio("L'attrezzo "+ attrezzo +" � stato preso e messo nello zaino");
					return true;
					}
			else
				iO.mostraMessaggio("Spiacente ma la borsa � piena");}
			}
		else 
			iO.mostraMessaggio("Oggetto non presente");
		return false;
	}
	/**
	 * Prende un attrezzo dalla borsa, lo copia nella stanza e lo rimuove dalla borsa
	 * 
	 * @return true se l'operazione va a buon fine, altrimenti false con lo specifico messaggio di errore
	 */
	public boolean posa(String attrezzo) {
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPosato=this.partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
			if(this.partita.getStanzaCorrente().addAttrezzo(attrezzoPosato)){
				if(this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo)) 
					iO.mostraMessaggio(attrezzo +" � stato posato nella stanza");
					return true;}
				else
					iO.mostraMessaggio("Spiacente stanza piena");}
		else
			iO.mostraMessaggio("Oggetto non presente");
		
		return false;
	}

	/**
	 * Comando "Fine".
	 * 
	 */
	private void fine() {
		iO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		iO= new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}