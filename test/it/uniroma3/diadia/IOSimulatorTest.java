package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


	public class IOSimulatorTest {

	    private IOSimulator ioSimulator;
	    private List<String> righeDaLeggere;

	    @Before
	    public void setUp() {
	        righeDaLeggere = Arrays.asList("riga1", "riga2", "riga3");
	        ioSimulator = new IOSimulator(righeDaLeggere);
	    }

	    @Test
	    public void testLeggiRiga() {
	        assertEquals("riga1", ioSimulator.leggiRiga());
	        assertEquals("riga2", ioSimulator.leggiRiga());
	        assertEquals("riga3", ioSimulator.leggiRiga());
	    }

	    @Test
	    public void testLeggiRigaOltreLimite() {
	        ioSimulator.leggiRiga();
	        ioSimulator.leggiRiga();
	        ioSimulator.leggiRiga();
	        assertThrows(IndexOutOfBoundsException.class, () -> {
	            ioSimulator.leggiRiga();
	        });
	    }

	    @Test
	    public void testMostraMessaggio() {
	        ioSimulator.mostraMessaggio("messaggio1");
	        ioSimulator.mostraMessaggio("messaggio2");
	        List<String> messaggiProdotti = ioSimulator.getMessaggiProdotti();
	        assertEquals(2, messaggiProdotti.size());
	        assertEquals("messaggio1", messaggiProdotti.get(0));
	        assertEquals("messaggio2", messaggiProdotti.get(1));
	    }

	    @Test
	    public void testNextMessaggio() {
	        ioSimulator.mostraMessaggio("messaggio1");
	        ioSimulator.mostraMessaggio("messaggio2");
	        assertEquals("messaggio1", ioSimulator.nextMessaggio());
	        assertEquals("messaggio2", ioSimulator.nextMessaggio());
	    }

	    @Test
	    public void testHasNextMessaggio() {
	        ioSimulator.mostraMessaggio("messaggio1");
	        ioSimulator.mostraMessaggio("messaggio2");
	        assertTrue(ioSimulator.hasNextMessaggio());
	        ioSimulator.nextMessaggio();
	        assertTrue(ioSimulator.hasNextMessaggio());
	        ioSimulator.nextMessaggio();
	        assertFalse(ioSimulator.hasNextMessaggio());
	    }

	    @Test
	    public void testIndiceMessaggiMostrati() {
	        ioSimulator.mostraMessaggio("messaggio1");
	        ioSimulator.mostraMessaggio("messaggio2");
	        assertEquals("messaggio1", ioSimulator.nextMessaggio());
	        assertEquals("messaggio2", ioSimulator.nextMessaggio());
	        assertFalse(ioSimulator.hasNextMessaggio());
	    }
	}

