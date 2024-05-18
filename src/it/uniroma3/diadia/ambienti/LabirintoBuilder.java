package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Map<String, Stanza> getStanze() {
		return this.stanze;
	}
	
	/* Inserisce una stanza nella mappa */
	public void ultimaStanzaAggiuntaEAggiorna(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.stanze.put(stanza.getNome(), stanza);
	}
	
	/*Metodo che setta la stanza iniziale del gioco*/
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza s = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaIngresso(s);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	/*Metodo che specifica quale stanza sarà quella vincente*/
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza s = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(s);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	/* Permette di aggiungere una stanza adiacente in una certa direzione della
	   stanza corrente. */
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza c = this.stanze.get(stanzaCorrente);
		Stanza a = this.stanze.get(stanzaAdiacente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	/* Metodo che aggiunge un attrezzo nell'ULTIMA stanza aggiunta */
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if(this.ultimaStanzaAggiunta==null) {
			return this;
		}
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.ultimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoLucente) {
		Stanza stanza = new StanzaBuia(nome, attrezzoLucente);
		this.ultimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String nonSiPassa, String passPartout) {
		Stanza stanza = new StanzaBloccata(nome);
		this.ultimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

}
