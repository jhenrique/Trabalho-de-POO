/** Classe para executar a opção 10 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao10 extends Menu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao10( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}

	@Override
	public void executa(Biblioteca biblioteca) {
		Usuario usuarioEmprestimoDevolucao = getUsuario();
		notNull("Usuario", usuarioEmprestimoDevolucao);
		resposta = input("Digite o Titulo do Livro a devolvido do Emprestimo");
		Publicacao publicacao = biblioteca.pesquisaLivroPor(resposta);
		notNull("Livro", publicacao);
		biblioteca.devolucaoDeItemNaRelacaoDeEmprestimo(usuarioEmprestimoDevolucao, publicacao);
		mensagem ();
	}

	private Usuario getUsuario() {
		resposta = input("Digite o nome do Usuario");
		return (Usuario) manipuladorBiblioteca.buscaUsuarioPor(resposta);
	}
	

}
