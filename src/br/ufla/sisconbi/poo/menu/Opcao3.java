/** Classe para executar a opção 3 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.io.ConstrutorEmprestimo;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao3 extends Menu {

	private ManipuladorBiblioteca manipuladorBiblioteca;

	public Opcao3(ManipuladorBiblioteca manipuladorBiblioteca) {
		construtor = new ConstrutorEmprestimo(manipuladorBiblioteca);
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}
	
	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Digite o nome do usuario");
		Usuario usuario = (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
		resposta = "Obs: Guarde o(s) código(s) do(s) livro(s) que pretende alugar, será necessário posteriormente. \n";
		outputMessage(resposta + manipuladorBiblioteca.impressaoDePublicacaoSemAluguel(biblioteca.publicacoesCadastradas()));
		biblioteca.novoEmprestimo(usuario, ((Emprestimo)construtor.get()));
		mensagem ();
	}

}
