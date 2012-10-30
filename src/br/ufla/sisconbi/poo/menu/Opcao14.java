/** Classe para executar a opção 14 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao14 extends Menu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao14( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}

	@Override
	public void executa(Biblioteca biblioteca) {
		String message = "======= Lista de Publicações ========== \n";
		message += manipuladorBiblioteca.impressaoDePublicacoes(biblioteca.publicacoesCadastradas());
		outputMessage(message);
		mensagem ();
	}

}
