package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String nonSiPassa;
	private String passPartout;

	public StanzaBloccata(String nome) {
		super(nome);
		this.nonSiPassa = null;      //direzione bloccata
		this.passPartout = null;   //consente di sbloccare la strada
	}
	
	
	


	public StanzaBloccata setPass(String passPartout) {
		this.passPartout=passPartout;
		return this;
	}
	
	public Object getPassPartout() {
		// TODO Auto-generated method stub
		return null;
	}


	public StanzaBloccata setBlocco(String blocco) {
		this.nonSiPassa=blocco;
		return this;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.nonSiPassa.equals(direzione)&& !this.hasAttrezzo(passPartout)) {
			return this;
		}
		else return super.getStanzaAdiacente(direzione);	
	} 
	
	@Override
	public String getDescrizione() {
		
		if(this.getAttrezzi().get(passPartout)==null && this.getAdiacenze().containsKey(nonSiPassa))
			return "Stanza Bloccata, bisogna forzarla";
		else
			return this.toString();


	}


	public String getDirezioneBloccata() {
		// TODO Auto-generated method stub
		return null;
	}





}