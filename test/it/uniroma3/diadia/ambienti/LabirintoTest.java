package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Funzione di test per la classe labirinto
 * 
 */
public class LabirintoTest {
	
	private static final String VINCENTE = "vincente";
	private static final String INIZIALE = "iniziale";
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(INIZIALE)
				.addStanzaVincente(VINCENTE)
				.getLabirinto();
	}

	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(INIZIALE, this.labirinto.getStanzaIniziale().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(VINCENTE, this.labirinto.getStanzaVincente().getNome());
	}

}