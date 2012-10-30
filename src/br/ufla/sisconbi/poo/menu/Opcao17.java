/** Classe para executar a opção 17 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Periodico;

public class Opcao17 extends Menu {
	
	public Opcao17() {
		construtor = new ConstrutorPeriodico();
	}

	@Override
	public void executa(Biblioteca biblioteca) {
		biblioteca.adicionaPublicacao((Periodico) construtor.get());
		mensagem ();
	}

}
