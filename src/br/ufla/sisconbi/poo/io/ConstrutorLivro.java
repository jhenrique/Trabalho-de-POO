/** Classe para construir Livros
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import br.ufla.sisconbi.poo.model.Livro;

public class ConstrutorLivro extends ConstrutorDeObjetos{
	
	public Object get() {
		return new Livro(titulo(), editora(), ano(), autores());
	}

	private String titulo() {
		return input("Digite o titulo do Livro");
	}
	
	private String autores() {
		return input("Digite o nome dos autores");
	}
	
	private String editora() {
		return input("Digite o nome da editora");
	}

	private String ano() {
		return input("Digite o ano do Livro");
	}
}