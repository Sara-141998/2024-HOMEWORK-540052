package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLuce;

	public StanzaBuia(String nome) {
		super(nome);
		attrezzoLuce=null;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLuce))
			return this.toString();
		else
			return ("qui c'è un buio pesto");
	}
	public void setAttrezzoIlluminante(String nomeAttrezzo) {
		this.attrezzoLuce=nomeAttrezzo;
	}

}
