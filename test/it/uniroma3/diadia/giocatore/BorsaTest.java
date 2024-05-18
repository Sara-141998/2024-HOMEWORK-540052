package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.SortedSet;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * classe di test della classe Borsa
 *
 */
public class BorsaTest {

	private Borsa borsa;
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Attrezzo penna;
	private Attrezzo tablet;

	
	@Before
	public  void setUp() {
		borsa= new Borsa();
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
	
	  @Test
	    public void testGetContenutoOrdinatoPerPeso() {
	        borsa.addAttrezzo(penna);
	        List<Attrezzo> attrezziOrdinati = borsa.getContenutoOrdinatoPerPeso();
	        assertEquals(penna, attrezziOrdinati.get(0));
	        
	       
	    }

	    @Test
	    public void testGetContenutoOrdinatoPerNome() {
	        borsa.addAttrezzo(penna);
	        borsa.addAttrezzo(tablet);
	        SortedSet<Attrezzo> attrezziOrdinati = borsa.getContenutoOrdinatoPerNome();
	        assertEquals(penna, attrezziOrdinati.first());
	        
	    }

	  

	    @Test
	    public void testGetSortedSetOrdinatoPerPeso() {
	        borsa.addAttrezzo(tablet);
	        borsa.addAttrezzo(penna);
	        SortedSet<Attrezzo> attrezziOrdinati = borsa.getSortedSetOrdinatoPerPeso();
	        assertEquals(tablet, attrezziOrdinati.last());
	    }
    

   
	
}