/** Classe Livro
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.model;

import java.io.Serializable;

public class Livro extends Publicacao implements Serializable {


	private static final long serialVersionUID = 1L;
	private  String autores;
	
	public Livro(String titulo, String editora, String ano, String autores) {
		super (titulo, editora, ano);
		this.autores = autores;
	}
	
	public String getAutores() {
		return autores;
	}
	
	@Override
	public boolean equals(Object obj) {
		Livro livro = (Livro) obj;
		return this.titulo.equals(livro.getTitulo()) & autores.equals(livro.getAutores())
		& codPublicacao.equals(livro.getCodPublicacao());
	}
	
	@Override
	public String toString() {
		return titulo+" "+autores;
	}
	
	
}
