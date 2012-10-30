package br.ufla.sisconbi.poo.test;

import junit.framework.TestCase;
import br.ufla.sisconbi.poo.model.Livro;

public class LivroTeste extends TestCase {

	Livro livro;
	
	public void testCriarLivro() {
		assertEquals("TDD Beck", livro.toString());
	}
	
	public void testEqualdadeDeLivro(){
		assertTrue(livro.equals(livro));
	}
	
	public void setUp(){
		livro = new Livro("TDD","Editora","2012","Beck");
	}
}
