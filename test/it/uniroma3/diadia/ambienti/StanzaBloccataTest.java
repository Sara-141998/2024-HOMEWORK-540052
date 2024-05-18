package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanza;
	private Attrezzo passPartout;
	private Stanza nord;
	private Stanza sud;
	private Stanza est;
	private Stanza ovest;
	
	@Before
	public void setUp() {
		stanza = new StanzaBloccata("stanza");
		passPartout= new Attrezzo("calcolatrice", 1);
		nord = new Stanza("nord");
		sud = new Stanza("sud");
		est= new Stanza("est");
		ovest=new Stanza("ovest");
		stanza.impostaStanzaAdiacente("nord", nord);
		stanza.impostaStanzaAdiacente("est", est);
		stanza.impostaStanzaAdiacente("sud", sud);
		stanza.impostaStanzaAdiacente("ovest", ovest);
		stanza.setPass("calcolatrice");
		stanza.setBlocco("ovest");
	}

	@Test
	public void testGetDescrizioneConPassPartout() {
		stanza.addAttrezzo(passPartout);
		assertNotEquals(" dovrebbe stampare una descrizione normale", "stanza\nUscite:  nord est sud ovest\nAttrezzi nella stanza: calcolatrice (1kg) ", stanza.getDescrizione());
	}
	@Test
	public void testGetDescrizioneSenzaPassPartout() {
		assertEquals(" dovrebbe stampare una descrizione speciale", "Stanza Bloccata, bisogna forzarla", stanza.getDescrizione());
	}

	@Test
	public void testGetStanzaAdiacenteConPassPartout() {
		stanza.addAttrezzo(passPartout);
		assertEquals(" dovrebbe essere quella", ovest ,stanza.getStanzaAdiacente("ovest"));
		
	}
	@Test
	public void testGetStanzaAdiacenteSenzaPassPartout() {
		assertEquals(" dovrebbe essere quella", stanza ,stanza.getStanzaAdiacente("ovest"));
		
	}
 
	
}
