/** Classe para executar a opção 4 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import java.util.Map;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Opcao4 extends Menu {

	private ManipuladorBiblioteca manipuladorBiblioteca;
	
	public Opcao4( ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}

	@Override
	public void executa(Biblioteca biblioteca) {
		impressaoDeLivros(biblioteca);
		String livroString = nomeDoLivro();
		int numeroEmprestimo = getNumeroDeEmprestimo(biblioteca);
		Map<Usuario, Emprestimo> map = biblioteca.relacaoDeEmprestimos();
		Emprestimo emprestimo = retornaEmprestimoPeloNumero(map, numeroEmprestimo);
		notNull("Emprestimo", emprestimo);
		Publicacao publicacao = biblioteca.pesquisaLivroPor( livroString );
		notNull("Livro", publicacao);
		emprestimo.getRegistros().add(new Registro( publicacao ));
		biblioteca.liberacaoDeUnicoLivro(publicacao);
		mensagem ();
	}

	private int getNumeroDeEmprestimo(Biblioteca biblioteca) {
		resposta = "Lista de Emprestimos da biblioteca \n";
		resposta += manipuladorBiblioteca.impressaoDeEmprestimos(biblioteca.relacaoDeEmprestimos());
		
		resposta += "\n Digite o numero do emprestimo";
		int numeroEmprestimo = Integer.parseInt(input(resposta));
		return numeroEmprestimo;
	}

	private void impressaoDeLivros(Biblioteca biblioteca) {
		resposta = "Lista de livros da biblioteca \n";
		resposta += manipuladorBiblioteca.impressaoDePublicacaoSemAluguel(biblioteca.publicacoesCadastradas());
		outputMessage(resposta);
	}

	private String nomeDoLivro() {
		return input("Digite o Titulo do livro a ser inserido");
	}
	
	private Emprestimo retornaEmprestimoPeloNumero( Map<Usuario, Emprestimo> map, int numeroEmprestimo) {
		for(Emprestimo emprestimo:map.values()){
			if ( emprestimo.getNumero() == numeroEmprestimo)return emprestimo;
		}
		return null;
	}


}
