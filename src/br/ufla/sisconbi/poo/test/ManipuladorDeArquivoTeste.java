package br.ufla.sisconbi.poo.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufla.sisconbi.poo.io.ManipuladorDeIODeUsuarios;
import br.ufla.sisconbi.poo.io.ManipuladorIODeLivro;
import br.ufla.sisconbi.poo.io.ManipuladorIODeRelacaoDeEmprestimos;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Livro;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;
import junit.framework.TestCase;

public class ManipuladorDeArquivoTeste extends TestCase {

	private List<Usuario> usuarios;
	private Map<Publicacao, Boolean> livros;
	private Map<Usuario, Emprestimo> relacaoDeEmprestimo;
	
	public void testGravacaoELeituraDeUsuarios() throws FileNotFoundException{
		ManipuladorDeIODeUsuarios manipuladorDeIODeUsuarios = new ManipuladorDeIODeUsuarios();
		manipuladorDeIODeUsuarios.grava(usuarios);
		assertEquals(usuarios.toString(),manipuladorDeIODeUsuarios.ler().toString());
	}
	
	public void testGravacaoELeituraDeLivro() throws FileNotFoundException{
		ManipuladorIODeLivro manipuladorIODeLivro = new ManipuladorIODeLivro();
		manipuladorIODeLivro.grava(livros);
		assertEquals(livros.toString(), manipuladorIODeLivro.ler().toString());
	}
	
	public void testGravacaoELeituraDeRelacaoDeEmprestimos() throws FileNotFoundException{
		ManipuladorIODeRelacaoDeEmprestimos maniladorIODeRegistroDeEmprestimos = new ManipuladorIODeRelacaoDeEmprestimos();
		maniladorIODeRegistroDeEmprestimos.grava(relacaoDeEmprestimo);
		assertEquals(relacaoDeEmprestimo.toString(), maniladorIODeRegistroDeEmprestimos.ler().toString());
	}
	
	
	public void setUp(){
		usuarios = new ArrayList<Usuario>();
		Usuario lucas = new Usuario("Lucas","124","Rua","123");
		Usuario samuel = new Usuario("Samuel","124","Rua","123");
		Publicacao livro = new Livro("Nunca Deixe de Tentar","editora","2301", "Michael Jordan");
		List<Registro> registros = new ArrayList<Registro>();
		registros.add(new Registro(livro));
		Emprestimo emprestimo = new Emprestimo(registros);
		usuarios.add(lucas);
		usuarios.add(samuel);
		livros = new HashMap<Publicacao, Boolean>();
		livros.put(livro, true);
		relacaoDeEmprestimo = new HashMap<Usuario, Emprestimo>();
		relacaoDeEmprestimo.put(lucas, emprestimo);
	}

}
