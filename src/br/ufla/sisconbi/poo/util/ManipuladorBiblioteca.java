/** Classe Manipular a Biblioteca
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Livro;
import br.ufla.sisconbi.poo.model.Publicacao;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;

public class ManipuladorBiblioteca {
	
	private Biblioteca biblioteca ;
	
	public ManipuladorBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public  Object buscaUsuarioPor(String nome) {
		for(Usuario usuario: biblioteca.usuariosCadastrados()){
			if(usuario.getNome().equals(nome)) return usuario;
		}return null;
	}
	
	public String impressaoDePublicacaoSemAluguel(Map<Publicacao, Boolean> map){
		String message = "";
		for(Publicacao publicacao: map.keySet()){	
			if(map.get(publicacao)) message += "\n Codigo = " +publicacao.getCodPublicacao() +" "+ publicacao.toString();
		}
		return message;
	}
	
	public String impressaoDePublicacoes(Map<Publicacao, Boolean> map){
		String message = "";
		for(Publicacao publicacao: map.keySet()){	
			message += "\n Codigo = " +publicacao.getCodPublicacao() +" "+ publicacao.toString();
		}
		return message;
	}

	private Publicacao buscaPublicacaoPor(Integer codigo) {
		for(Publicacao publicacao : biblioteca.publicacoesCadastradas().keySet()){
			if(publicacao.getCodPublicacao().equals(codigo)) return publicacao;
		}return null;
	}

	public List<Registro> getRegistrosDeEmprestimo(List<Integer> codigos) {
		List<Registro> registros = new ArrayList<Registro>();
		for (Integer codigo : codigos) registros.add(new Registro(buscaPublicacaoPor(codigo)));
		return registros;
	}

	
	public Biblioteca getBiblioteca(){
		return biblioteca;
	}

	public String impressaoDeEmprestimos(Map<Usuario, Emprestimo> relacaoDeEmprestimos) {
		String emprestimos = "";
		for (Emprestimo emprestimo : relacaoDeEmprestimos.values()) {
			emprestimos += "\n Codigo = " + emprestimo.getNumero()+ " Dia do emprestimo = " +emprestimo.getDataDeEmprestimo().get(Calendar.DAY_OF_MONTH);
		}
		return emprestimos;
	}


}