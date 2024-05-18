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

public class ComandoPrendiTest {

    private ComandoPrendi comandoPrendi;
    private Partita partita;
    private Stanza stanza;
    private IO io;

    @Before
    public void setUp() {
        comandoPrendi = new ComandoPrendi();
        partita = new Partita();
        stanza = new Stanza("stanza");
        io = new IOConsole();

        partita.setStanzaCorrente(stanza);
        partita.getGiocatore().setBorsa(new Borsa());
        comandoPrendi.setIo(io);
    }

    @Test
    public void testPrendiAttrezzoSuccesso() {
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        stanza.addAttrezzo(attrezzo);
        comandoPrendi.setParametro("martello");

        comandoPrendi.esegui(partita);

        assertFalse(stanza.hasAttrezzo("martello"));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testPrendiAttrezzoNonPresenteInStanza() {
        comandoPrendi.setParametro("martello");

        comandoPrendi.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    public void testPrendiAttrezzoBorsaPiena() {
        // Riempire la borsa al massimo (assumendo capacità 10 per questo esempio)
        for (int i = 0; i < 10; i++) {
            partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("attrezzo" + i, 1));
        }

        Attrezzo attrezzo = new Attrezzo("martello", 1);
        stanza.addAttrezzo(attrezzo);
        comandoPrendi.setParametro("martello");

        comandoPrendi.esegui(partita);

        assertTrue(stanza.hasAttrezzo("martello"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }
}
