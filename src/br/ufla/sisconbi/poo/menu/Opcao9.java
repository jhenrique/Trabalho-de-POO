/** Classe para executar a opção 9 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao9 extends Menu {

	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao9( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}

	
	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Digite o nome do Usuario");
		Usuario usuarioEmprestimoDevolucaoLivros = (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
		notNull("Usuario", usuarioEmprestimoDevolucaoLivros);
		interacaoDeRegistros(biblioteca, usuarioEmprestimoDevolucaoLivros);
		mensagem ();
	}


	private void interacaoDeRegistros(Biblioteca biblioteca,
			Usuario usuarioEmprestimoDevolucaoLivros) {
		for (Registro registro : biblioteca.relacaoDeEmprestimos().get(usuarioEmprestimoDevolucaoLivros).getRegistros()) {
			biblioteca.devolucaoDeItemNaRelacaoDeEmprestimo(usuarioEmprestimoDevolucaoLivros, registro.getLivro());
		}
	}

}
