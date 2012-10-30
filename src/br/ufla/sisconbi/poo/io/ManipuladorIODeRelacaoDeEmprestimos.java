/** Classe para realizar a Manipula��o de Entrada e Sa�da de Rela��o de Emprestimos
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import java.io.FileNotFoundException;
import java.util.Map;

import br.ufla.sisconbi.poo.model.Emprestimo;
import br.ufla.sisconbi.poo.model.Usuario;

public class ManipuladorIODeRelacaoDeEmprestimos extends ManipuladorIO {


	public ManipuladorIODeRelacaoDeEmprestimos() {
		super("emprestimo");
	
	}
	
	@Override
	public Map<Usuario, Emprestimo> ler() throws FileNotFoundException {
		preparaConexaoDeLeitura();
		try {
			return (Map<Usuario, Emprestimo>) arquivoDeLeitura.readObject();
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível ler os livros do arquivo");
		}
	}

}
