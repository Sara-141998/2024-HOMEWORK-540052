package it.uniroma3.diadia;

import java.util.Scanner;


/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;
    private String parametro;
    
    public Comando(String istruzione) {
  		Scanner scannerDiParole = new Scanner(istruzione);

  		// prima parola: nome del comando
  		if (scannerDiParole.hasNext())
  			this.nome = scannerDiParole.next(); 

  		// seconda parola: eventuale parametro
  		if (scannerDiParole.hasNext())
  			this.parametro = scannerDiParole.next();
    }
    
    
    

    public String getNome() {
        return this.nome;
    }
    public void setNome(String[] istruzioni, int indice) {
    	this.nome=istruzioni[indice];
    }
    public void setParametro(String[] istruzioni, int indice) {
    	this.parametro=istruzioni[indice];
    	}
    

    public String getParametro() {
        return this.parametro;
    }

    public String sconosciuto() {
        return (this.nome = null);
    }
    
}
