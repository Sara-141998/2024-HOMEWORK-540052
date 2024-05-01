package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private Partita session;
	private Stanza stanzaCorrente;
	private Stanza stanzaProssima;
	private Comando vai;
	


	
	@Before
	public void setUp() {
		session= new Partita();

		stanzaCorrente = new Stanza("corrente");
		stanzaProssima = new Stanza("prossima");
		stanzaCorrente.impostaStanzaAdiacente("nord", stanzaProssima);
		session.setStanzaCorrente(stanzaCorrente);
		vai= new ComandoVai();
		
	}

	@Test
	public void testVaiNull() {
		this.session.setStanzaCorrente(stanzaCorrente);
		this.vai.setParametro(null);
		this.vai.esegui(session);
		assertNotEquals(stanzaCorrente, session.getStanzaCorrente());

	
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		this.session.setStanzaCorrente(stanzaCorrente);
		this.stanzaCorrente.impostaStanzaAdiacente("est", stanzaProssima);
		this.vai.setParametro("nord");
		this.vai.esegui(session);
		assertNotEquals(stanzaProssima, this.session.getStanzaCorrente());

	
	}
	
	
	@Test
	public void testVaiDirezioneEsistente() {
	 
		this.session.setStanzaCorrente(stanzaCorrente);
		this.stanzaCorrente.impostaStanzaAdiacente("est", stanzaProssima);
		this.vai.setParametro("est");
		this.vai.esegui(session);
		assertNotEquals(stanzaProssima, this.session.getStanzaCorrente());
	
	}
}