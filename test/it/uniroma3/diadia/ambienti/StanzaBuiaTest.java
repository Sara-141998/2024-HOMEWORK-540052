package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;
    private Attrezzo lanterna;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
        lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    public void testGetDescrizioneConAttrezzoLucente() {
        stanzaBuia.addAttrezzo(lanterna);
        assertEquals(stanzaBuia.toString(), stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneSenzaAttrezzoLucente() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }

 
    @Test
    public void testGetDescrizioneConAttrezzoIlluminanteDiverso() {
        stanzaBuia.setAttrezzoIlluminante("torcia");
        Attrezzo torcia = new Attrezzo("torcia", 1);
        stanzaBuia.addAttrezzo(torcia);
        assertEquals(stanzaBuia.toString(), stanzaBuia.getDescrizione());
    }
}


