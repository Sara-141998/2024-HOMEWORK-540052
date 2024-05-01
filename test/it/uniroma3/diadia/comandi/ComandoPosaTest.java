package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita session;
	private Attrezzo chiave;
	private Comando posa;
	private FabbricaDiComandi fabbrica;


	
	@Before
	public void setUp() {
		session = new Partita();

		chiave = new Attrezzo("chiave",1);
		session.getStanzaCorrente();
		this.session.getGiocatore().getBorsa().addAttrezzo(chiave);
		posa = new ComandoPosa();
		fabbrica = new FabbricaDiComandiFisarmonica();


	}

	@Test
	public void testEseguiComandoPrendiConParametro() {
		assertNull(session.getStanzaCorrente().getAttrezzo("chiave"));
		posa = fabbrica.costruisciComando("posa chiave");

		posa.esegui(this.session);
		assertEquals("Errore,dovrebbe stampare chiave",chiave, session.getStanzaCorrente().getAttrezzo("chiave"));

	
	}
	@Test
	public void testEseguiComandoSenzaParametro() {
		assertEquals(false ,session.getStanzaCorrente().hasAttrezzo("chiave"));
		posa = fabbrica.costruisciComando("posa");

		posa.esegui(this.session);
		assertEquals(false ,session.getStanzaCorrente().hasAttrezzo("chiave"));

	
	}

}

