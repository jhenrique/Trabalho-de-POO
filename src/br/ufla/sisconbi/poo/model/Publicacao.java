/** Classe Publicação
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.model;

import java.io.Serializable;

public abstract class Publicacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Integer codPublicacao;
	protected  String titulo;
	protected  String editora;
	protected  String ano;

	public Publicacao (String titulo, String editora, String ano ){
		this.codPublicacao = (int) (Math.random() * 10000);
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}
	
	public String getTitulo(){
		return this.titulo;
	}

	public Integer getCodPublicacao() {
		return codPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public String getAno() {
		return ano;
	}

}
