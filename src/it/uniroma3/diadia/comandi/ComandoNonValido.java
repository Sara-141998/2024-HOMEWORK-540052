package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	public static final String OUTPUT_NON_VALIDO = "Comando non valido";
	private IO io;
	
	

	@Override
	public void esegui(Partita partita) {
		if(io!=null)io.mostraMessaggio(OUTPUT_NON_VALIDO);
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public IO getIO() {
		return this.io;
	}

}
