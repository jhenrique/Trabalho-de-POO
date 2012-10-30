/** Classe Biblioteca
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */


package br.ufla.sisconbi.poo.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
	
	private List<Usuario> usuarios;
	private Map<Publicacao, Boolean> estoqueDePublicacao;
	private Map<Usuario, Emprestimo> relacaoDeEmprestimos;
	
	public Biblioteca() {
		usuarios = new ArrayList<Usuario>(); 
		estoqueDePublicacao = new HashMap<Publicacao, Boolean>();
		relacaoDeEmprestimos = new HashMap<Usuario, Emprestimo>();
	}
	/**
	 * Método para adicionar Usuário
	 * */
	public void adicionaUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	/**
	 * Método para Listar usuários
	 * */
	public List<Usuario> usuariosCadastrados() {
		return usuarios ;
	}
	
	/**
	 * Método para adicionar Publicação
	 * */
	public void adicionaPublicacao(Publicacao publicacao) {
		boolean status = true;
		if (publicacao instanceof Periodico) status = false;
		this.estoqueDePublicacao.put(publicacao, status);
	}
	/**
	 * Método para Listar Publicações Cadastradas
	 * */
	public Map<Publicacao, Boolean> publicacoesCadastradas(){
		return estoqueDePublicacao;
	}
	
	/**
	 * Método para remoção de Publicações
	 * */
	public void remocaoDePublicacaoPor(String titulo) {
		estoqueDePublicacao.remove(publicacaoPorTitulo(titulo));
	}
	
	/**
	 * Método para Pesquisar Livro por Titulo
	 * */
	public Publicacao pesquisaLivroPor(String titulo) {
		return publicacaoPorTitulo(titulo);
	}
	
	/**
	 * Método para Pesquisar Livro por Autor
	 * */
	public Publicacao pesquisaLivroPorAutor(String nome) {
		return livroNaListaPorAutor(nome);
	}
	
	/**
	 * Método para pesquisar publicação por Titulo
	 * */
	private Publicacao publicacaoPorTitulo(String argumento){
		for(Publicacao livro: estoqueDePublicacao.keySet()){
			 if(livro.getTitulo().equals(argumento)) return livro;
		}return null;
	}
	/**
	 * Método para listar os livros em uma lista de Publicações
	 * */
	private Publicacao livroNaListaPorAutor(String argumento) {
		for(Publicacao publicacao: estoqueDePublicacao.keySet()){
			if(publicacao instanceof Livro){
				if (((Livro) publicacao).getAutores().equals(argumento)) return publicacao;
			}
		}return null;
	}
	
	public Map<Usuario, Emprestimo> relacaoDeEmprestimos() {
		return relacaoDeEmprestimos;
	}
	/**
	 * Método para realizar um novo emprestimo
	 * */
	public void novoEmprestimo(Usuario usuario, Emprestimo emprestimo) {
		if ( usuario.getDataPenalizacao() == null || usuario.getDataPenalizacao().compareTo(new GregorianCalendar()) > 0 ){
			manipulacaoDeEstadoDoLivro(emprestimo.getRegistros(), false);
			relacaoDeEmprestimos.put(usuario, emprestimo);
		}
	}
	/**
	 * Método para excluir Usuário
	 * */

	public void excluiUsuario(Usuario usuario) {
		if (!relacaoDeEmprestimos.containsKey(usuario))
			usuarios.remove(usuario);
	}
	/**
	 * Método para excluir um emprestimo
	 * */
	public void exclusaoDeEmprestimoPelo(Usuario usuario) {
		manipulacaoDeEstadoDoLivro(relacaoDeEmprestimos.get(usuario).getRegistros(), true);
		relacaoDeEmprestimos.remove(usuario);
	}
	/**
	 * Método para devolução de um item
	 * */
	public void devolucaoDeItemNaRelacaoDeEmprestimo(Usuario usuario,Publicacao livro) {
		Emprestimo emprestimo = relacaoDeEmprestimos.get(usuario);
		int diasdeAtraso = diferencaDeDatas(new GregorianCalendar().getTimeInMillis(), emprestimo.getDataPrevistaParaDevolucao().getTimeInMillis());
		if(diasdeAtraso >0) usuario.setDataPenalizacao(diasdeAtraso * 3);
		
		relacaoDeEmprestimos.get(usuario).devolucao(livro);
		estoqueDePublicacao.put(livro, true);
	}
	/**
	 * Método para calcular diferença de datas
	 * */
	private int diferencaDeDatas(long dataAtual, long dataDevolucao){
		return (int) (dataAtual - dataDevolucao)/1000/60/60/24;
	}
	/**
	 * Método para manipulação de estados do Livro
	 * */
	private void manipulacaoDeEstadoDoLivro(List<Registro> registros, boolean novoEstado) {
		for (Registro registro : registros)
			estoqueDePublicacao.put(registro.getLivro(), novoEstado);
	}
	
	public void liberacaoDeUnicoLivro(Publicacao livro) {
		estoqueDePublicacao.put(livro, false);
	}

	public void setUsuarios(Object lista) {
		usuarios = (List<Usuario>) lista;
	}

	public void setLivros(Object lista) {
		estoqueDePublicacao = (Map<Publicacao, Boolean>) lista;
		
	}

	public void setEmprestimos(Object lista) {
		relacaoDeEmprestimos = (Map<Usuario, Emprestimo>) lista;
	}
}
