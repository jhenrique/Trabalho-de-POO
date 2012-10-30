/** Classe para montar o Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.menu;

import javax.swing.JOptionPane;

import br.ufla.sisconbi.poo.io.ConstrutorDeObjetos;
import br.ufla.sisconbi.poo.model.Biblioteca;

public abstract class Menu {
	

	protected ConstrutorDeObjetos construtor;
	protected String resposta;
	
	public abstract void executa(Biblioteca biblioteca);
	
	
	protected void notNull (String mensagem, Object obj ){
		if ( obj == null )JOptionPane.showMessageDialog(null,
				mensagem+" nao econtrado",
			    null,
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	protected void mensagem () {
		JOptionPane.showMessageDialog(null,
			    "Operacao realizada com Sucesso",
			    null,
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	public String input(String message){
		return JOptionPane.showInputDialog(null,message);
	}
	
	protected void outputMessage(String message){
		JOptionPane.showMessageDialog(null,
			    message,
			    null,
			    JOptionPane.PLAIN_MESSAGE);
	}

}
