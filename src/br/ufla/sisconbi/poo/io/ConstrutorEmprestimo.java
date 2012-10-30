/** Classe que constroi EMprestimos
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import java.util.ArrayList;
import java.util.List;

import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class ConstrutorEmprestimo extends ConstrutorDeObjetos {

	private ManipuladorBiblioteca manipuladorBiblioteca;
	private String resposta;
	
	/**
	 * Método para construir um Emprestimo
	 * */
	public ConstrutorEmprestimo(ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
	}
	
	public Object get() {
		return new Emprestimo(registros());
	}
	/**
	 * Método Lista Registros
	 * */
	private List<Registro> registros() {
		int quantidadeDeLivro = quantidadeDeLivrosParaEmprestimo();
		List<Integer> codigos = new ArrayList<Integer>(); 
		entradaDeCodigoDeLivro(quantidadeDeLivro, codigos);
		return manipuladorBiblioteca.getRegistrosDeEmprestimo(codigos);
	}
	
	/**
	 * Método para entrada Codigo do Livro
	 * */

	private void entradaDeCodigoDeLivro(int quantidadeDeLivro,List<Integer> codigos) {
		for (int i = 0; i < quantidadeDeLivro; i++) {
			resposta = input("Digite o codigo do Livro");
			codigos.add(Integer.parseInt(resposta));
		}
	}
	
	/**
	 * Método para entrada de quantidades de Livro
	 * */
	private int quantidadeDeLivrosParaEmprestimo(){
		resposta = input("Digite a quantidade de livros que deseja alugar");
		return Integer.parseInt(resposta);
	}
}