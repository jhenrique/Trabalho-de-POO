/** Classe para executar a opção 13 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;

import java.util.List;

import br.ufla.sisconbi.poo.model.Biblioteca;
import br.ufla.sisconbi.poo.model.Usuario;

public class Opcao13 extends Menu {

	@Override
	public void executa(Biblioteca biblioteca) {
		String message = "======= Lista de Usuarios ==========";
		List<Usuario> lista = biblioteca.usuariosCadastrados();
		notNull("Usuarios", lista);
		impressaoDeUsuario(message,lista);

	}

	private void impressaoDeUsuario(String message, List<Usuario> lista) {
		for (Usuario usuario : lista) {
			message += "\n"+ usuario.toString();
			message += "--------------------------------";
		}
		outputMessage(message);
	}

}
