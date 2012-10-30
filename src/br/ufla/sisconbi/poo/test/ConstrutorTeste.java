package br.ufla.sisconbi.poo.test;

import junit.framework.TestCase;
import br.ufla.sisconbi.poo.io.ConstrutorDeObjetos;
import br.ufla.sisconbi.poo.io.ConstrutorEmprestimo;
import br.ufla.sisconbi.poo.io.ConstrutorLivro;
import br.ufla.sisconbi.poo.io.ConstrutorUsuario;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Livro;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class ConstrutorTeste extends TestCase {
	
	private ConstrutorDeObjetos construtor;
	
	public void testCriacaoDeUsuario(){
		construtor = new ConstrutorUsuario();
		//assertEquals(new Usuario("Lucas","123","Rua","123").toString(), construtor.get().toString());
	}
	
	public void testCriacaoDeLivro(){
		construtor = new ConstrutorLivro();
		//assertEquals(new Livro("TDD", "Beck").toString(), construtor.get().toString());
	}

	public void testCriacaoDeEmprestimo(){
		Biblioteca biblioteca = new Biblioteca();
		Livro livro = new Livro("TDD","Editora","2012","Beck");
		biblioteca.adicionaPublicacao(livro);
		System.out.println("Codigo: "+livro.getCodPublicacao());
		assertNotNull(new ConstrutorEmprestimo(new ManipuladorBiblioteca(biblioteca)).get());
	}
}
