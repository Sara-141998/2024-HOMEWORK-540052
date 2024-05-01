package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		stanza= new StanzaBuia("stanza");
		lanterna= new Attrezzo("lanterna", 2);
		stanza.impostaStanzaAdiacente("nord", null);
		stanza.impostaStanzaAdiacente("est", null);
		stanza.impostaStanzaAdiacente("sud", null);
		stanza.impostaStanzaAdiacente("ovest", null);
		stanza.setAttrezzoIlluminante("lanterna");
	}
	
	@Test
	public void testGetDescrizioneConLanterna() {
		stanza.addAttrezzo(lanterna);
		assertEquals(" dovrebbe stampare una descrizione normale", "stanza\nUscite:  nord est sud ovest\nAttrezzi nella stanza: lanterna (2kg) ", stanza.getDescrizione());
	}
	@Test
	public void testGetDescrizioneSenzaLanterna() {
		assertEquals(" dovrebbe stampare una descrizione speciale", "qui c'è un buio pesto", stanza.getDescrizione());
	}

}
