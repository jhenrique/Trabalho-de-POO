/** Classe para construir Usu�rios
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */


package br.ufla.sisconbi.poo.io;



import br.ufla.sisconbi.poo.model.Usuario;

public class ConstrutorUsuario extends ConstrutorDeObjetos {

	public Object get() {
		return new Usuario(nome(),cpf(),endereco(),telefone());
	}

	private String telefone() {
		return input("Digite o telefone");
	}

	private String endereco() {
		return input("Digite o Endereço");	
	}

	private String cpf() {
		return input("Digite o CPF");
	}

	private String nome() {
		return input("Digite o nome do Usuário");
	}
}
