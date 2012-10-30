/** Classe para executar a opção 7 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao7 extends Menu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao7( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}


	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Nome do Usuario deste emprestimo");
		Usuario usuarioEmprestimos = (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
		biblioteca.exclusaoDeEmprestimoPelo(usuarioEmprestimos);
		mensagem ();
	}
}
