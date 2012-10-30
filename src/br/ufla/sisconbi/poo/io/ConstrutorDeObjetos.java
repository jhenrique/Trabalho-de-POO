/** Classe para construir os Objetos
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;


import javax.swing.JOptionPane;

public abstract class ConstrutorDeObjetos {

	/**
	 * Método para mostrar a Mensagem na Tela
	 * 
	 * */
	public String input(String message){
		return JOptionPane.showInputDialog(null,message);
	}
	
	public abstract Object get();
}
