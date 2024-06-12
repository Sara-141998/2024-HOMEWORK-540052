package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	private final static String NOME = "aiuto";
	static final private String[] elencoComandi = {"vai + <direzione>", "aiuto", "fine", "prendi + <nomeAttrezzo>", "posa + <nomeAttrezzo>", "guarda",
			                                       "interagisci", "saluta", "nonValido"};

	private IO io;

	public ComandoAiuto(String[] elencocomandi2) {
		super.setNome(NOME);
	}
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			if(io!=null)io.mostraMessaggio(elencoComandi[i]+" ");
		if(io!=null)io.mostraMessaggio(" ");
	}

	public String getNome() {
		return NOME;
	}

	
}
