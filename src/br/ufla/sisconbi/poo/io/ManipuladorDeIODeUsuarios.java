/** Classe para realizar a manipula��o de Usu�rios
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import java.io.FileNotFoundException;
import java.util.List;

import br.ufla.sisconbi.poo.model.Usuario;

public class ManipuladorDeIODeUsuarios extends ManipuladorIO{

	public ManipuladorDeIODeUsuarios() {
		super("usuario");
	}
	
	/**
	 * Método para Ler Usuários do Arquivo
	 * */
	public List<Usuario> ler () throws FileNotFoundException {
		preparaConexaoDeLeitura();
		try {
			List<Usuario> usuarios =   (List<Usuario>) super.arquivoDeLeitura.readObject();
			super.arquivoDeLeitura.close();
			return usuarios;
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível ler os usuários do arquivo");
		}
	}

}
