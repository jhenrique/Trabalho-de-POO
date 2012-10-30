/** Classe para executar a opção 5 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao5 extends Menu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao5( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}


	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Nome do Usuario a ser excluido");
		Usuario usuarioExcluir = (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
		notNull("Usuario", usuarioExcluir);
		biblioteca.excluiUsuario(usuarioExcluir);
		mensagem ();

	}

}
