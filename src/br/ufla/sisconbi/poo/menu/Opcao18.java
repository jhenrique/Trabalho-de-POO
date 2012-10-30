/** Classe para executar a opção 18 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;

public class Opcao18 extends Menu {
	

	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Titulo do Periódico a ser excluido");
		biblioteca.remocaoDePublicacaoPor(resposta);
		mensagem ();
	}

}
