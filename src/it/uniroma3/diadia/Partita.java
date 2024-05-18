package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private int cfu;
	
	public Partita(){
		labirinto= new Labirinto();
		this.finita = false;
		this.stanzaCorrente= labirinto.getStanzaCorrente();
		setStanzaVincente(labirinto.getStanzaVincente());
		this.giocatore= new Giocatore();
	}

	public Partita(Labirinto lab) {
		this.labirinto = lab;
		this.stanzaCorrente = lab.getStanzaCorrente();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 *  @return vero se partita vinta
	 */
	
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * 
	 * @return restituisce la stanza corrente
	 */
	public Stanza getStanzaCorrente() {
		return stanzaCorrente ;
	}

	/**
	 * 
	 * @return il giocatore
	 */
	public Giocatore getGiocatore(){
		return giocatore;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	/**
	 * aggiorna la stanza corrente con la prossima stanza 
	 *
	 */
	public void setStanzaCorrente(Stanza prossimaStanza) {
		this.stanzaCorrente=prossimaStanza;
		
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	/**
     * restituisce i cfu
     * @return cfu
     */
    public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}	
}
