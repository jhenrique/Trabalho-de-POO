
/** Classe Principal que inicializa o Programa
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.ufla.sisconbi.poo.io.ManipuladorDeIODeUsuarios;
import br.ufla.sisconbi.poo.io.ManipuladorIO;
import br.ufla.sisconbi.poo.io.ManipuladorIODeLivro;
import br.ufla.sisconbi.poo.io.ManipuladorIODeRelacaoDeEmprestimos;
import br.ufla.sisconbi.poo.menu.ControladorDeMenu;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class Principal {

	/**
	 * Método que inicializa o programa
	 * */
	public static void main(String[] args) throws IOException  {
		Biblioteca biblioteca = inicializacao();
		ManipuladorBiblioteca manipuladorBiblioteca = new ManipuladorBiblioteca(biblioteca);
		ControladorDeMenu menu = new ControladorDeMenu(manipuladorBiblioteca);
		menu.principal();
		
	}
	/**
	 * Método que inicializa os Manipuladores do Programa
	 * */
	private static Biblioteca inicializacao() throws FileNotFoundException {
		Biblioteca biblioteca = new Biblioteca();
		ManipuladorIO manipuladorDeArquivo = new ManipuladorIODeLivro();
		ManipuladorIO manipuladorDeArquivoUsuario = new ManipuladorDeIODeUsuarios();
		ManipuladorIO manipuladorDeEmprestimos = new ManipuladorIODeRelacaoDeEmprestimos();
		if(manipuladorDeEmprestimos.ler() != null) biblioteca.setEmprestimos(manipuladorDeEmprestimos.ler());
		
		biblioteca.setUsuarios(manipuladorDeArquivoUsuario.ler());
		biblioteca.setLivros(manipuladorDeArquivo.ler());
		return biblioteca;
	}
	
	

}
