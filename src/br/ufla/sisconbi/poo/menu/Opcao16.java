/** Classe para executar a opção 16 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.io.ManipuladorDeIODeUsuarios;
import br.ufla.sisconbi.poo.io.ManipuladorIO;
import br.ufla.sisconbi.poo.io.ManipuladorIODeLivro;
import br.ufla.sisconbi.poo.io.ManipuladorIODeRelacaoDeEmprestimos;
import br.ufla.sisconbi.poo.model.Biblioteca;

public class Opcao16 extends Menu {

	@Override
	public void executa(Biblioteca biblioteca) {
		ManipuladorIO manipuladorEmprestimos = new ManipuladorIODeRelacaoDeEmprestimos();
		ManipuladorIO manipuladorDeArquivo = new ManipuladorIODeLivro();
		ManipuladorIO manipuladorDeArquivoUsuario = new ManipuladorDeIODeUsuarios();
		manipuladorEmprestimos.grava(biblioteca.relacaoDeEmprestimos());
		manipuladorDeArquivo.grava(biblioteca.publicacoesCadastradas());
		manipuladorDeArquivoUsuario.grava(biblioteca.usuariosCadastrados());
		System.exit(0);

	}

}
