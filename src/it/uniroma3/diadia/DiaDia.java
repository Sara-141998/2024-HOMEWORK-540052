package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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

	

	private Partita partita;
	private IO io;

	public DiaDia(IO io2) {
		this.partita = new Partita();
		this.io=io2;
	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione=io.leggiRiga();}
		while(!processaIstruzione(istruzione));


	}

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco 
	 * ntinua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire ;

		FabbricaDiComandi fabbrica= new FabbricaDiComandiFisarmonica();
		comandoDaEseguire=fabbrica.costruisciComando(istruzione);
		comandoDaEseguire.setIo(this.io);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			
	}   
		return false;
}		
	public Partita getPartita() {
		return this.partita;
	}
	

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}