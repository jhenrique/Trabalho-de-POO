/** Classe Para Manipular Entrada e Sa�da de Livros
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import java.io.FileNotFoundException;
import java.util.Map;

import br.ufla.sisconbi.poo.model.Publicacao;

public class ManipuladorIODeLivro extends ManipuladorIO{

	public ManipuladorIODeLivro() {
		super("livro");
	}
	
	/**
	 * Método para Leitura de Livros
	 * */
	public  Map<Publicacao, Boolean> ler () throws FileNotFoundException {
		preparaConexaoDeLeitura();
		try {
			return (Map<Publicacao, Boolean>) arquivoDeLeitura.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Não foi possível ler os livros do arquivo");
		} 
	}



}
