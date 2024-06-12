package it.uniroma3.diadia.ambienti;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class LabirintoBuilderTest {

	private LabirintoBuilder labirintoBuilder;

	@Before
	public void setUp() {
		labirintoBuilder = new LabirintoBuilder();
	}

	@Test
	public void testAddStanzaIniziale() {
		labirintoBuilder.addStanzaIniziale("Atrio");
		Labirinto labirinto = labirintoBuilder.getLabirinto();
		assertEquals("Atrio", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testAddStanzaVincente() {
		labirintoBuilder.addStanzaVincente("Tesoro");
		Labirinto labirinto = labirintoBuilder.getLabirinto();
		assertEquals("Tesoro", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testAddStanza() {
		labirintoBuilder.addStanza("Biblioteca");
		Map<String, Stanza> stanze = labirintoBuilder.getStanze();
		assertTrue(stanze.containsKey("Biblioteca"));
	}

	@Test
	public void testAddAdiacenza() {
		labirintoBuilder.addStanza("Atrio").addStanza("Biblioteca");
		labirintoBuilder.addAdiacenza("Atrio", "Biblioteca", "nord");
		Stanza atrio = labirintoBuilder.getStanze().get("Atrio");
		assertEquals("Biblioteca", atrio.getStanzaAdiacente("nord").getNome());
	}

	@Test
	public void testAddAttrezzo() {
		labirintoBuilder.addStanza("Atrio").addAttrezzo("Spada", 5);
		Stanza atrio = labirintoBuilder.getStanze().get("Atrio");
		assertNotNull(atrio.getAttrezzo("Spada"));
		assertEquals(5, atrio.getAttrezzo("Spada").getPeso());
	}

	@Test
	public void testAddStanzaMagica() {
		labirintoBuilder.addStanzaMagica("StanzaMagica");
		Stanza stanzaMagica = labirintoBuilder.getStanze().get("StanzaMagica");
		assertTrue(stanzaMagica instanceof StanzaMagica);
	}

}
