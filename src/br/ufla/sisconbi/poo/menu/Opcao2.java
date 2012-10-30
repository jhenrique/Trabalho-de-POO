/** Classe para executar a opção 2 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.io.ConstrutorLivro;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Livro;

public class Opcao2 extends Menu {

	public Opcao2() {
		construtor = new ConstrutorLivro();
	}
	
	@Override
	public void executa(Biblioteca biblioteca) {
		biblioteca.adicionaPublicacao((Livro) construtor.get());
		mensagem ();
	}

}
