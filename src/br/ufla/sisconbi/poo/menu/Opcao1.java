/** Classe para executar a opção 1 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.menu;

import br.ufla.sisconbi.poo.io.ConstrutorUsuario;
import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Usuario;



public class Opcao1 extends Menu{
	
	public Opcao1() {
		construtor =  new ConstrutorUsuario();
	}
	
	public void executa(Biblioteca biblioteca){
		biblioteca.adicionaUsuario((Usuario)construtor.get());
		mensagem ();
	}

}
