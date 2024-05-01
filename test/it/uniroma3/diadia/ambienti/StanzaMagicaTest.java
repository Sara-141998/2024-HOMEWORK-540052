package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagic;
	private Attrezzo bacchetta;
	private Attrezzo portafortuna;
	
	@Before
	public void setUp() {
		stanzaMagic= new StanzaMagica("magic", 1);
		bacchetta= new Attrezzo("bacchetta",3);

		portafortuna= new Attrezzo("portafortuna",2);
	}
	@Test
	public void testAddAttrezzoConUnAttrezzoNessunaReazione() {
		assertNull( stanzaMagic.getAttrezzo("portafortuna"));
		stanzaMagic.addAttrezzo(portafortuna);
		assertEquals("Errore, la stanza non dovrebbe impazzire", portafortuna, stanzaMagic.getAttrezzo("portafortuna"));
	}
	@Test
	public void testAddAttrezzoConDueAttrezziConReazione() {
		stanzaMagic.addAttrezzo(portafortuna);
		stanzaMagic.addAttrezzo(bacchetta);
		assertEquals("Errore, il nome  non dovrebbe essere invertito", "portafortuna (2kg)", stanzaMagic.getAttrezzo("portafortuna").toString());
		assertEquals("Errore, il nome non dovrebbe essere invertito", portafortuna, stanzaMagic.getAttrezzo("portafortuna"));
		
	}
	

}
