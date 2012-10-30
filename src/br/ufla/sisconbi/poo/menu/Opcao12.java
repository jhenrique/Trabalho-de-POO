/** Classe para executar a opção 12 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;

public class Opcao12 extends Menu {

	@Override
	public void executa(Biblioteca biblioteca) {
		String autores = input("Digite o Autor do livro");
		notNull("Livro", biblioteca.pesquisaLivroPorAutor( autores ));
		outputMessage(biblioteca.pesquisaLivroPorAutor( autores ).toString());
	}

}
