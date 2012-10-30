/** Classe Periodico
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.model;

import java.io.Serializable;

public class Periodico extends Publicacao implements Serializable {


	private static final long serialVersionUID = 1L;
	protected String numEdicao;
	protected String mes;
	
	
	public Periodico (String titulo, String editora, String ano, String numEdicao, String mes) {
		super (titulo, editora, ano);
		this.numEdicao = numEdicao;
		this.mes = mes;
	}


	public String getNumEdicao() {
		return numEdicao;
	}


	public void setNumEdicao(String numEdicao) {
		this.numEdicao = numEdicao;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}
	
	@Override
	public String toString() {
		return getTitulo()+ " "+ getAno()+ " "+getMes() +" "+getEditora();
	}
	

}
