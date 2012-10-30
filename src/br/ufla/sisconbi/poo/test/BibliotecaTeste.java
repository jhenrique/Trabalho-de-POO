package br.ufla.sisconbi.poo.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Livro;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;
import junit.framework.TestCase;

public class BibliotecaTeste extends TestCase {

	private Biblioteca biblioteca;
	private Publicacao publicacao;
	private List<Registro> registros;
	private String dataPrevista;
	private String dataCorrente;
	private Usuario usuario;
	private Emprestimo emprestimo;
	
	public void testGetListaDeUsuarios(){
		assertListaVazia(biblioteca.usuariosCadastrados().toString());
	}
	
	public void testAdicionaUsuarios(){
		biblioteca.adicionaUsuario(usuario);
		assertEquals("[Lucas 123 RUA 123]", biblioteca.usuariosCadastrados().toString());
	}
	
	public void testAdicionaPublicacao(){
		biblioteca.adicionaPublicacao(publicacao);
		assertEquals("{TDD Beck=true}", biblioteca.publicacoesCadastradas().toString());
	}
	
	public void testGetListaDePublicacao(){
		assertMapVazio(biblioteca.publicacoesCadastradas().toString());
	}
	
	public void testExcluicaoDePorTituloPublicacao(){
		biblioteca.adicionaPublicacao(publicacao);
		biblioteca.remocaoDePublicacaoPor("TDD");
		assertMapVazio(biblioteca.publicacoesCadastradas().toString());
	}
	
	public void testComparacaoDePublicacaoPorTitulo(){
		biblioteca.adicionaPublicacao(publicacao);
		assertEquals("TDD Beck", biblioteca.pesquisaLivroPor("TDD").toString());
	}
	
	public void testPesquisaDePublicacaoPorAutor(){
		biblioteca.adicionaPublicacao(publicacao);
		assertEquals(publicacao, biblioteca.pesquisaLivroPorAutor("Beck"));
	}
	
	public void testGetRelacaoDeEmprestimo(){
		assertMapVazio(biblioteca.relacaoDeEmprestimos().toString());
	}
	
	public void testCriacaoDeRelacaoDeEmprestimo(){
		configuracaoDeDatas();
		biblioteca.novoEmprestimo(usuario, emprestimo);
		assertEquals("{Lucas 123 RUA 123="+emprestimo.getNumero()+" "+dataCorrente+" "+dataPrevista+" [TDD Beck]}", biblioteca.relacaoDeEmprestimos().toString());
	}
	
	public void testExcluirUsuario(){
		criacaodeEmprestimo();
		biblioteca.excluiUsuario(usuario);
		assertTrue(biblioteca.usuariosCadastrados().contains(usuario));
	}
	
	public void testExcluirEmprestimo(){
		criacaodeEmprestimo();
		biblioteca.exclusaoDeEmprestimoPelo(usuario);
		assertMapVazio(biblioteca.relacaoDeEmprestimos().toString());
	}
	
	public void testDevolucaoDeItemNaRelacaoDeEmprestimo(){
		criacaodeEmprestimo();
		biblioteca.devolucaoDeItemNaRelacaoDeEmprestimo(usuario, publicacao);
		assertEquals(new GregorianCalendar().get(Calendar.DAY_OF_MONTH), biblioteca.relacaoDeEmprestimos().get(usuario).getRegistros().get(0).getDataDeDevolucao().get(Calendar.DAY_OF_MONTH));
	}
	
	public void testCalculoDePenalidade(){
		criacaodeEmprestimo();
		biblioteca.devolucaoDeItemNaRelacaoDeEmprestimo(usuario, publicacao);
		assertNull(biblioteca.usuariosCadastrados().get(0).getDataPenalizacao());	
	}

	private void assertMapVazio(String map){
		assertEquals("{}", map);
	}
	
	private void assertListaVazia(String lista){
		assertEquals("[]", lista);
	}
	
	private void criacaodeEmprestimo() {
		biblioteca.adicionaUsuario(usuario);
		biblioteca.novoEmprestimo(biblioteca.usuariosCadastrados().get(0), emprestimo);
	}

	private void configuracaoDeDatas(){
		GregorianCalendar dataPrevistaDevolucao = new GregorianCalendar();
		GregorianCalendar dataAtual = new GregorianCalendar();
		dataPrevistaDevolucao.set(Calendar.DAY_OF_MONTH, new GregorianCalendar().get(Calendar.DAY_OF_MONTH)+10);
		dataPrevista = String.valueOf(dataPrevistaDevolucao.get(Calendar.DAY_OF_MONTH));
		dataCorrente = String.valueOf(dataAtual.get(Calendar.DAY_OF_MONTH));
	}
	
	public void setUp(){
		biblioteca = new Biblioteca();
		publicacao = new Livro("TDD","Editora","2012","Beck");
		registros = new ArrayList<Registro>();
		registros.add(new Registro(publicacao));
		usuario = new Usuario("Lucas", "123", "RUA", "123");
		emprestimo = new Emprestimo(registros);
	}
}
