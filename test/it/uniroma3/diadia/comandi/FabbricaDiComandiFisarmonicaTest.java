package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandi fabbrica;
	private Comando comandoDiTest;

	
	@Before
	public void setUp() {

		fabbrica = new FabbricaDiComandiFisarmonica();
		
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		comandoDiTest=fabbrica.costruisciComando("aiuto");
		assertEquals("Errore, il nome del comando deve essere quello!", "aiuto", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoFine() {
		comandoDiTest=fabbrica.costruisciComando("fine");
		assertEquals("Errore, il nome del comando deve essere quello!", "fine", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoGuarda() {
		comandoDiTest=fabbrica.costruisciComando("guarda");
		assertEquals("Errore, il nome del comando deve essere quello!", "guarda", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoNonValido() {
		comandoDiTest=fabbrica.costruisciComando("impiccati");
		assertEquals("Errore, il nome del comando deve essere quello!", "comando non valido", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoVaiSenzaParametro() {
		comandoDiTest=fabbrica.costruisciComando("vai");
		assertEquals("Errore, il nome del comando deve essere quello!", "vai", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoVaiConParametro() {
		comandoDiTest=fabbrica.costruisciComando("vai nord");
		assertEquals("Errore, il nome del comando deve essere quello!", "vai", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","nord",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPrendiSenzaParametro() {
		comandoDiTest=fabbrica.costruisciComando("prendi");
		assertEquals("Errore, il nome del comando deve essere quello!", "prendi", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPrendiConParametro() {
		comandoDiTest=fabbrica.costruisciComando("prendi bottino");
		assertEquals("Errore, il nome del comando deve essere quello!", "prendi", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","bottino",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPosaSenzaParametro() {
		comandoDiTest=fabbrica.costruisciComando("posa");
		assertEquals("Errore, il nome del comando deve essere quello!", "posa", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPosaConParametro() {
		comandoDiTest=fabbrica.costruisciComando("posa malloppo");
		assertEquals("Errore, il nome del comando deve essere quello!", "posa", comandoDiTest.getNome());
		assertEquals("Errore, il parametro deve corrispondere","malloppo",comandoDiTest.getParametro() );
	}
}
