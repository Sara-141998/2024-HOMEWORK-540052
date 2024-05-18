package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	public static final int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this (nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		super(nome);
		contatoreAttrezziPosati=0;
		this.sogliaMagica=sogliaMagica;
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}
	@Override 
		public boolean addAttrezzo(Attrezzo attrezzo) {
			if (this.contatoreAttrezziPosati>this.sogliaMagica)
				attrezzo = this.modificaAttrezzo(attrezzo);
			this.contatoreAttrezziPosati++;
			return super.addAttrezzo(attrezzo);
		}

}
