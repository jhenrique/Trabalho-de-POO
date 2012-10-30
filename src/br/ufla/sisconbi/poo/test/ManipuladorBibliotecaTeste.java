package br.ufla.sisconbi.poo.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Livro;
import br.ufla.sisconbi.poo.model.Usuario;
import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class ManipuladorBibliotecaTeste extends TestCase {
	
	private Biblioteca biblioteca;
	private ManipuladorBiblioteca manipuladorBiblioteca;
	private Usuario usuario;
	
	public void testBuscaDeUsuarioPorNome(){
		biblioteca.adicionaUsuario(usuario);
		assertTrue(usuario.equals(manipuladorBiblioteca.buscaUsuarioPor("Lucas")));
	}
	
	public void testImpressao(){
		biblioteca.adicionaPublicacao(new Livro("LIVRO","Varios","2013","ratata"));
		manipuladorBiblioteca.impressaoDePublicacaoSemAluguel(biblioteca.publicacoesCadastradas());
	}
	
	public void testCriacaoDeRegistrosPorCodigosDeLivro(){
		List<Integer> codigos = new ArrayList<Integer>();
		Livro livro = new Livro("TDD","Editora","2012","Beck");
		biblioteca.adicionaPublicacao(livro);
		codigos.add(livro.getCodPublicacao());
		assertNotNull(manipuladorBiblioteca.getRegistrosDeEmprestimo(codigos));
	}
	
	public void setUp(){
		biblioteca = new Biblioteca();
		manipuladorBiblioteca = new ManipuladorBiblioteca(biblioteca);
		usuario = new Usuario("Lucas", "123", "Rua", "123");
	}
}
