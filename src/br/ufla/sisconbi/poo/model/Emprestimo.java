/** Classe Emprestimo
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Emprestimo implements Serializable{


	private static final long serialVersionUID = 1L;
	private int numero;
	private GregorianCalendar dataPrevistaParaDevolucao;
	private List<Registro> registros;
	private GregorianCalendar dataDeEmprestimo;
	private static  int PRAZO_DE_ENTREGA = 10;
	
	public Emprestimo(List<Registro> registros) {
		this.numero = (int) (Math.random() * 10000);
		inicializacaoDeDatas();
		this.registros = registros;
	}
	/**
	 * Método para pesquisar registro por publicação
	 * */

	private Registro pesquisaRegistroPor(Publicacao publicacao) {
		for(Registro registro: registros){
			if(registro.getLivro().equals(publicacao))return registros.get(registros.indexOf(registro));
		}return null;
	}

	public List<Registro> getRegistros() {
		return registros;
	}
	/**
	 * Método para devolução de um Livro
	 * */
	public void devolucao(Publicacao publicacao) {
		pesquisaRegistroPor(publicacao).setDataDeDevolucao(new GregorianCalendar());
	}

	public int getNumero() {
		return numero;
	}

	public GregorianCalendar getDataPrevistaParaDevolucao() {
		return dataPrevistaParaDevolucao;
	}
	
	public GregorianCalendar getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	/**
	 * Método para inicializar datas
	 * */
	private void inicializacaoDeDatas() {
		this.dataDeEmprestimo = new GregorianCalendar();
		this.dataPrevistaParaDevolucao = new GregorianCalendar();
		this.dataPrevistaParaDevolucao.set(Calendar.DAY_OF_MONTH, new GregorianCalendar().get(Calendar.DAY_OF_MONTH) + PRAZO_DE_ENTREGA );	
	}
	
	@Override
	public String toString(){
		return numero+" "+dataDeEmprestimo.get(Calendar.DATE)+" "+dataPrevistaParaDevolucao.get(Calendar.DATE)+" "+registros;
	}

}
