/** Classe para executar a opção 15 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import java.util.Calendar;
import java.util.Map;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Registro;
import br.ufla.sisconbi.poo.model.Usuario;

public class Opcao15 extends Menu {

	@Override
	public void executa(Biblioteca biblioteca) {
		String message = "=============== Emprestimos ============== \n" ;
		Map<Usuario, Emprestimo> listaEmprestimos = biblioteca.relacaoDeEmprestimos();	
		notNull("Emprestimos", listaEmprestimos);
		for(Emprestimo emprestimo:listaEmprestimos.values()){
				message +="\n \n Codigo: "+emprestimo.getNumero()+" Dia de Emprestimo: "+
						emprestimo.getDataDeEmprestimo().get(Calendar.DAY_OF_MONTH)+" Dia Previsto de Devolucao: "+
						emprestimo.getDataPrevistaParaDevolucao().get(Calendar.DAY_OF_MONTH);
				for (Registro registro : emprestimo.getRegistros()) {
					if (registro.getDataDeDevolucao() == null) message +="\n" +registro.getLivro().toString();
				}
		}
		outputMessage(message);
		mensagem ();

	}

}