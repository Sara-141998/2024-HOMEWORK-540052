package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * classe di test della classe Borsa
 *
 */
public class BorsaTest {

	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Attrezzo penna;
	private Attrezzo tablet;

	
	@Before
	public  void setUp() {
		borsaPiena= new Borsa();
		borsaVuota= new Borsa();
		this.penna= new Attrezzo("penna", 10);
		this.tablet= new Attrezzo("tablet", 4);
		this.borsaPiena.addAttrezzo(penna);

		
	}
	
	/**
	 * Test metodo removeAttrezzo
	 */

	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertEquals("Errore, non c'� la penna", false , this.borsaVuota.removeAttrezzo("penna"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaPiena() {
		assertEquals("Errore, l'attrezzo � presente e lo zaino � pieno", true , this.borsaPiena.removeAttrezzo("penna"));
    }
	
	@Test
	public void testRemoveAttrezzoBorsaPienaAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo � presente e lo zaino � pieno", false , this.borsaPiena.removeAttrezzo("tablet"));
	}
	
	/**
	 * Test metodo addAttrezzo
	 */
	@Test
	public void testAddAttrezzo() {
        assertNotEquals(tablet , this.borsaPiena.addAttrezzo(penna));

	}

	@Test
	public void testAddAttrezzoBorsaPiena() {
        assertEquals("Errore, non avrebbe potuto aggiungerlo", false , this.borsaPiena.addAttrezzo(tablet));

	}

	@Test
	public void testAddAttrezzoBorseVuota() {
		assertEquals(" avrebbe dovuto aggiungerlo", true, this.borsaVuota.addAttrezzo(tablet));

	}


	/**
	 * Test metodo hasAttrezzo
	 */

	@Test
	public void testHasAttrezzoAttrezzoPresente() {
		assertEquals("l'attrezzo � presente", true, this.borsaPiena.hasAttrezzo("penna"));
	}

	@Test
	public void testHasAttrezzoAttrezzoNonPresente() {
		assertEquals(" l'attrezzo non � presente", false, this.borsaPiena.hasAttrezzo("quaderno"));
	}
	@Test
	public void testHasAttrezzoAttrezzoPresenteBis() {
		assertEquals(" non ci sono proprio attrezzi qui", false, this.borsaVuota.hasAttrezzo("computer"));
	}

	@Test
	public void testHasAttrezzoAttrezzoSconosciuto() {
		assertEquals(" l'attrezzo non esiste proprio", false, this.borsaPiena.hasAttrezzo("gomma"));
    }

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoAttrezzoPresente() {
		assertEquals(" l'attrezzo � presente", penna , this.borsaPiena.getAttrezzo("penna"));
	}

	@Test
	public void testGetAttrezzoAttrezzoNonPresente() {
		assertEquals(" l'attrezzo non � presente", null, this.borsaPiena.getAttrezzo("quaderno"));
	}
	@Test
	public void testGetAttrezzoAttrezzoPresenteBis() {
		assertEquals(" non ci sono proprio attrezzi qui", null, this.borsaVuota.getAttrezzo("computer"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals(" l'attrezzo non esiste proprio", null , this.borsaPiena.getAttrezzo("gomma"));


	}
	
}
