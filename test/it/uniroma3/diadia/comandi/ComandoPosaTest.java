package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {

    private ComandoPosa comandoPosa;
    private Partita partita;
    private Stanza stanza;
    private IO io;

    @Before
    public void setUp() {
        comandoPosa = new ComandoPosa();
        partita = new Partita();
        stanza = new Stanza("stanza");
        io = new IOConsole();

        partita.setStanzaCorrente(stanza);
        partita.getGiocatore().setBorsa(new Borsa());
        comandoPosa.setIo(io);
    }

    @Test
    public void testPosaAttrezzoSuccesso() {
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        comandoPosa.setParametro("martello");

        comandoPosa.esegui(partita);

        assertTrue(stanza.hasAttrezzo("martello"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testPosaAttrezzoNonPresenteInBorsa() {
        comandoPosa.setParametro("martello");

        comandoPosa.esegui(partita);

        assertFalse(stanza.hasAttrezzo("martello"));
    }

}

