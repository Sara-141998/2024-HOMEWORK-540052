package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO{
	
private Scanner scannerDiLinee;
	
	public IOConsole() {
		this.scannerDiLinee = new Scanner(System.in);
	}
	
	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee = scannerDiLinee;
	}
	
	/**
	 * Stampa il messaggio su schermo per l'utente.
	 * @param msg
	 */
	public void mostraMessaggio(String msg) {
		
		System.out.println(msg);
		
	}
	/**
	 * Legge un'intera riga inserita come input da tastiera.
	 * @return la riga scansionata
	 */
	public String leggiRiga() {
		
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}