package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
private static final String NOME = "guarda";
	
	public ComandoGuarda() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().toString());
		super.getIO().mostraMessaggio("Informazioni partita: " + partita.getGiocatore().toString());
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
		return "guarda";
	}
	
}
