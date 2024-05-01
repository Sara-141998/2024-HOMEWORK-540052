package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe di test per la classe Stanza
 * 
 *@author sara
 */
public class StanzaTest {

	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo tablet;
	private Attrezzo quaderno;
	private Attrezzo computer;
	private Attrezzo penna;
	private Stanza stanzaPiena;


	

	@Before
	public void setUp() {

		this.stanza = new Stanza("Stanza di prova");
		this.stanzaAdiacente= new Stanza("stanza adiacente");
		this.tablet= new Attrezzo("tablet", 10);
		this.quaderno= new Attrezzo("quaderno", 1);
		this.computer=new Attrezzo("computer", 1);
		this.penna= new Attrezzo("penna", 2);
	    this.stanzaPiena= new Stanza("stanza piena");
		this.stanzaPiena.addAttrezzo(tablet);
		this.stanzaPiena.addAttrezzo(quaderno);
		this.stanzaPiena.addAttrezzo(computer);
		this.stanzaPiena.addAttrezzo(penna);

	/**
     * Test metodo impostaStanzaAdiacente
     */
			
	}
	
    @Test
    public void testImpostaStanzaAdiacenteNord() {
        Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
        stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
	public void testImpostaStanzaAdiacenteEst() {
    	Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("est"));
	}
	@Test
	public void testImpostaStanzaAdiacenteSud() {
		Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaStanzaAdiacenteOvest() {
		Stanza stanzaAdiacente = new Stanza("Stanza adiacente");
		stanza.impostaStanzaAdiacente("ovest", stanzaAdiacente);
		assertEquals(stanzaAdiacente , stanza.getStanzaAdiacente("ovest"));
	}

	/**
	 * Test metodo addAttrezzo
	 */
	
	@Test
	public void testAddAttrezzoStanzaVuota() {
		assertEquals(" avrebbe dovuto aggiungerlo", true, this.stanzaAdiacente.addAttrezzo(tablet));

	}

	@Test
    public void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(quaderno));
    }
    
	 @Test
	 public void testAddAttrezzoDiverso() {
	    assertTrue(stanza.addAttrezzo(tablet));
	    }

	/**
	 * Test metodo hasAttrezzo
	 */

	 @Test
	 public void testHasAttrezzo() {
	    assertEquals(true, stanzaPiena.hasAttrezzo("tablet")); 
	    }
	 
	 @Test
		public void testHasAttrezzoConAttrezzoNonPresenteBis() {
			assertEquals( false, this.stanzaAdiacente.hasAttrezzo("bottiglia"));
		}

		@Test
		public void testHasAttrezzoConAttrezzoSconosciuto() {
			assertEquals( false, this.stanzaPiena.hasAttrezzo("righello"));

		}
	

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		    Attrezzo attrezzo = new Attrezzo("telefono",5);
	        stanza.addAttrezzo(attrezzo);
	        assertEquals(attrezzo, stanza.getAttrezzo("telefono"));
	    }
	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals(" l'attrezzo non è presente", null, this.stanzaPiena.getAttrezzo("mouse"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals(" non ci sono proprio attrezzi qui", null, this.stanzaAdiacente.getAttrezzo("orologio"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals(" l'attrezzo non esiste proprio", null , this.stanzaPiena.getAttrezzo("matita"));


	}

	/**
	 * Test metodo removeAttrezzo
	 */

	@Test
	 public void testRemoveAttrezzoStanzaVuota() {
		  assertEquals("Non ci sono attrezzi",false, stanza.removeAttrezzo("penna"));
	  }
	
	@Test
	public void testRemoveAttrezzoConAttrezzoNonPresente() {

		assertEquals(" l'attrezzo non era presente", false , this.stanzaPiena.removeAttrezzo("calcolatrice"));
	}
	
	@Test
	public void testRemoveAttrezzoConAttrezzoNullo() {
		assertEquals(" non gli avevi dato nulla da rimuovere", false, this.stanzaPiena.removeAttrezzo(null));
	}
}