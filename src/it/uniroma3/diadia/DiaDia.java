package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 * 
 */

public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	public static final String OUTPUT_VITTORIA = "Hai vinto!";
	public static final String OUTPUT_ESAURIMENTO_CFU = "Hai esaurito i CFU...";

	private Partita partita;
	private IO io;

	public DiaDia(IO io2, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io = io2;
	}

	public DiaDia(Labirinto lab, IO io) {
		this.partita = new Partita(lab);
		this.io = io;

	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();
		} while (!processaIstruzione(istruzione));

	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco ntinua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		AbstractComando comandoDaEseguire;

		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.io);
		comandoDaEseguire.esegui(this.partita);

		if (this.partita.vinta()) {
			io.mostraMessaggio(OUTPUT_VITTORIA);
			if ((this.partita.getGiocatore().getCfu() == 0))
				io.mostraMessaggio(OUTPUT_ESAURIMENTO_CFU);
			return this.partita.isFinita();
		}
		return false;
	}

	public Partita getPartita() {
		return this.partita;
	}

	public static void main(String[] argc) {
		Scanner scannerDiLinee = new Scanner(System.in);
		IO ioConsole = new IOConsole(scannerDiLinee);
		IOConsole io = new IOConsole();
		Labirinto labirinto = Labirinto.newBuilder().addStanzaIniziale("LabCampusOne").addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne", "Biblioteca", "ovest").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		try {
			gioco.gioca();
		} catch (Exception e) {
			ioConsole.mostraMessaggio("Errore inaspettato!");
		} finally {
			scannerDiLinee.close();
		}
    }
}