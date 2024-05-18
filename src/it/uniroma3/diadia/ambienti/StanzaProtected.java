package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	protected Map<String, Attrezzo> nomeAttrezzi;
	protected int numeroAttrezzi;
	protected Stanza[] stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected Map<String, StanzaProtected> direzioniStanze;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioniStanze = new HashMap<>();
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.nomeAttrezzi = new HashMap<>();
	}
	
	public List<StanzaProtected> getStanzeAdiacenti() {
		return (List<StanzaProtected>) direzioniStanze.values();
	}

	public void setStanzeAdiacenti(Map<String, StanzaProtected> stanzeAdiacenti) {
		this.direzioniStanze = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		boolean aggiornato = false;

		if (direzioniStanze.containsKey(direzione)) {
			this.direzioniStanze.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioniStanze.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public StanzaProtected getStanzaAdiacente(String direzione) {
		StanzaProtected stanza = null;
		if (this.direzioniStanze.containsKey(direzione))
			stanza = this.direzioniStanze.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.nomeAttrezzi.values();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.nomeAttrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione  di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza .
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {	
		return this.nomeAttrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo  se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.nomeAttrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.nomeAttrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza .
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
			this.nomeAttrezzi.remove(attrezzo.getNome(), attrezzo);

			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @return restituisce la posizioni possibili di una determinata stanza
	 */
	public Set<String> getDirezioni() {

		return direzioniStanze.keySet();
	}

}