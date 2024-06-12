package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	
	private Partita partita;
    private Stanza stanzaVincente;
    private Stanza stanzaCorrente;
    private Giocatore giocatore1;
    private Stanza altraStanza;
    private Stanza nuovaStanza;
    private Stanza stanza1;
    private Labirinto labirinto;
    
    
    @Before
    public void setUp() {
    	this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
    }
 //metodi per getStanza vincente
    
    @Test
    public void testGetStanzaVincenteNotNull() {
        partita.setStanzaCorrente(stanzaVincente);
        assertNotNull(partita.getStanzaVincente());
    }

    @Test
    public void testGetStanzaVincenteConfronto() {
        partita.setStanzaCorrente(stanzaVincente);
        assertNotEquals(stanzaVincente, partita.getStanzaVincente());
    }

    @Test
    public void testGetStanzaVincenteDiversaDaAltraStanza() {
        partita.setStanzaCorrente(stanzaVincente);
        assertNotEquals(altraStanza, partita.getStanzaVincente());
    }
    
    // Metodi di test per setStanzaVincente

    @Test
    public void testSetStanzaVincenteNotNull() {
        partita.setStanzaCorrente(stanzaVincente);
        assertNotNull(partita.getStanzaVincente());
    }


    @Test
    public void testSetStanzaVincenteDiversaDaAltraStanza() {
        partita.setStanzaCorrente(stanzaVincente);
        assertNotEquals(altraStanza, partita.getStanzaVincente());
    }

    // Metodi di test per setStanzaCorrente

    @Test
    public void testSetStanzaCorrenteNull() {
        partita.setStanzaCorrente(stanzaCorrente);
        assertNull(partita.getStanzaCorrente());
    }

    @Test
    public void testSetStanzaCorrenteConfronto() {
        partita.setStanzaCorrente(stanzaCorrente);
        assertEquals(stanzaCorrente, partita.getStanzaCorrente());
    }

   
 // Metodi di test per getStanzaCorrente
    
    @Test
    public void testGetStanzaCorrente() {
    	partita.setStanzaCorrente(stanzaCorrente);
        assertEquals(stanzaCorrente, partita.getStanzaCorrente());
    }
    
    @Test
    public void testGetStanzaCorrente2() {
       assertNotEquals(stanza1,partita.getStanzaCorrente());
    }
    
    @Test
    public void testGetStanzaCorrente_DopoCambioStanza() {
       partita.setStanzaCorrente(nuovaStanza);
       assertEquals(nuovaStanza, partita.getStanzaCorrente());
} 

 //Metodi di test per vinta

    @Test
    public void testVintaFalseStanzaCorrenteDiversaDaVincente() {
        partita.setStanzaCorrente(altraStanza);
        assertFalse(partita.vinta());
    }

    @Test
    public void testVintaFalseStanzaCorrenteDiversaDaVincente2() {
        partita.setStanzaCorrente(stanza1);
        assertFalse(partita.vinta());
    }
    @Test
    public void testVintaStanzaCorrenteUgualeAStanzaVincente() {
        partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(partita.vinta());
    }
   

 // Metodi di test per isFinita

    @Test
    public void testIsFinitaTrueDopoSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());
    }
    
    @Test
    public void testIsFinitaPartitaNonFinita() {
        assertFalse(partita.isFinita());
    }
    
    @Test
    public void testIsFinita() {
       assertNotEquals(true, partita.isFinita());
    }


    //metodi di test per setCfu
    
    @Test
    public void testSetCfu() {
        partita.setCfu(10);
        assertEquals(10, partita.getCfu());
    }
    
    @Test
    public void testSetCfu1() {
        partita.setCfu(10);
        assertNotEquals(9, partita.getCfu());
    }
    @Test
    public void testSetCfu2() {
        partita.setCfu(20);
        assertNotNull(partita.getCfu());
    }

    
    
    /*@Test
    public void testGetLabirinto1() {
        assertNotNull(partita.getLabirinto());
    }
    
 
    //metodi di test per setGiocatore
    @Test
    public void testSetGiocatore() {
        partita.setGiocatore(giocatore);
        assertEquals(giocatore, partita.getGiocatore());
    }*/
    @Test
    public void testSetGiocatore2() {
        assertNotEquals(giocatore1, partita.getGiocatore());
    }
}

