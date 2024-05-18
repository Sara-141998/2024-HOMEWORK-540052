package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLucente;

	public StanzaBuia(String nome, String attrezzoLucente) {
		super(nome);
		this.attrezzoLucente= attrezzoLucente;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLucente))
			return this.toString();
		else
			return ("qui c'è un buio pesto");
	}
	public StanzaBuia setAttrezzoIlluminante(String nomeAttrezzo) {
		this.attrezzoLucente=nomeAttrezzo;
		return this;
	}

}

