/** Classe para construção de um Periódico
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.io.ConstrutorDeObjetos;
import br.ufla.sisconbi.poo.model.Periodico;

public class ConstrutorPeriodico extends ConstrutorDeObjetos {

	@Override
	public Object get() {
		return new Periodico(titulo(),editora(),ano(),numeroEdicao(), mes());
	}

	
	private String mes() {
		return input("Digite o mês de publicação");
	}


	private String titulo() {
		return input("Digite o titulo do Periódico");
	}
	
	private String numeroEdicao() {
		return input("Digite o número da edição");
	}
	
	private String editora() {
		return input("Digite o nome da editora");
	}

	private String ano() {
		return input("Digite o ano do Periódico");
	}
}
