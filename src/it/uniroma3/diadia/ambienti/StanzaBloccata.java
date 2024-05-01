package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String nonSiPassa;
	private String passPartout;

	public StanzaBloccata(String nome) {
		super(nome);
		nonSiPassa=null;      //direzione bloccata
		passPartout=null;   //consente di sbloccare la strada
	}
	
	public void setPass(String passPartout) {
		this.passPartout=passPartout;
		
	}

	public void setBlocco(String blocco) {
		this.nonSiPassa=blocco;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if(direzione != null) {
			for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
				if (this.direzioni[i].equals(direzione) && this.direzioni[i].equals(nonSiPassa)) {
					if(this.hasAttrezzo(passPartout))
						stanza = this.stanzeAdiacenti[i];
					else
						stanza= this;
				}
				if (this.direzioni[i].equals(direzione) && !this.direzioni[i].equals(nonSiPassa))
					stanza = this.stanzeAdiacenti[i];}
		}
		return stanza;
	}
	@Override
	public String getDescrizione() {
		for(int i=0;i<this.direzioni.length; i++)
			if(this.direzioni[i].contentEquals(nonSiPassa) && (!this.hasAttrezzo(passPartout))) {
				this.direzioni[i]="Stanza Bloccata";
				return "Stanza Bloccata, bisogna forzarla";}
			return this.toString();
	}
}