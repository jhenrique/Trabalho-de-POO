/** Classe para executar a opção 8 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao8 extends Menu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao8( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}


	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Digite o nome do Usuario");
		Usuario usuarioEmprestimoExclusao = (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
		notNull("Usuario", usuarioEmprestimoExclusao);
		Publicacao publicacao = livroParaExclusao(biblioteca);
		notNull("Livro", publicacao);
		biblioteca.devolucaoDeItemNaRelacaoDeEmprestimo(usuarioEmprestimoExclusao, publicacao);
		mensagem ();
	}


	private Publicacao livroParaExclusao(Biblioteca biblioteca) {
		return biblioteca.pesquisaLivroPor(input("Digite o Titulo do Livro a ser excluido do Emprestimo"));
	}
}
