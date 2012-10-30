/** Classe Para Manipular o Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.ufla.sisconbi.poo.util.ManipuladorBiblioteca;

public class ControladorDeMenu {
	
	private ManipuladorBiblioteca manipuladorBiblioteca;
	private static Map<String,Menu> opcoes;
	private Menu opcaoEcolhida;
	
	public ControladorDeMenu(ManipuladorBiblioteca manipuladorBiblioteca) {
		this.manipuladorBiblioteca = manipuladorBiblioteca;
		opcoes();
	}

	private void opcoes() {
		opcoes = new HashMap<String, Menu>();
		opcoes.put("1", new Opcao1());
		opcoes.put("2", new Opcao2());
		opcoes.put("3", new Opcao3(manipuladorBiblioteca));
		opcoes.put("4", new Opcao4(manipuladorBiblioteca));
		opcoes.put("5", new Opcao5(manipuladorBiblioteca));
		opcoes.put("6", new Opcao6());
		opcoes.put("7", new Opcao7(manipuladorBiblioteca));
		opcoes.put("8", new Opcao8(manipuladorBiblioteca));
		opcoes.put("9", new Opcao9(manipuladorBiblioteca));
		opcoes.put("10", new Opcao10(manipuladorBiblioteca));
		opcoes.put("11", new Opcao11());
		opcoes.put("12", new Opcao12());
		opcoes.put("13", new Opcao13());
		opcoes.put("14", new Opcao14(manipuladorBiblioteca));
		opcoes.put("15", new Opcao15());
		opcoes.put("0", new Opcao16());
		opcoes.put("16", new Opcao17());
		opcoes.put("17", new Opcao18());
	}
	
	private void entrada(String numero){
		opcaoEcolhida = opcoes.get(numero);
		opcaoEcolhida.executa(manipuladorBiblioteca.getBiblioteca());
	}
	
	public void principal() throws IOException {
		
		String textMenu = "=============================================== \n" +
		"Entre com a opcao desejada \n" +
		"1 - Cadastrar um novo usuario \n" +
		"2 - Cadastar um Livro \n"+
		"3 - Cadastrar um novo Emprestimo \n"+
		"4 - Inserir um novo item no Emprestimo \n"+
		"5 - Excluir um usuário \n"+
		"6 - Excluir uma Livro \n"+
		"7 - Excluir um Emprestimo \n"+
		"8 - Excluir um item de emprestimo \n"+
		"9 - Devolver todos os livros  do  emprestimo \n"+
		"10 - Devolver  um  livro  do  emprestimo \n"+
		"11 - Pesquisar  livros  por titulo \n"+
		"12 - Pesquisar  livros  por autor \n"+
		"13 - Listar todos os usuários \n"+
		"14 - Listar todas as Publicações \n"+
		"15 - Listar todos os Emprestimos \n"+
		"16 - Cadastrar periódico \n"+
		"17 - Excluir periódico \n"+
		"0 - SAIR \n"+
		"===============================================";
		String response = JOptionPane.showInputDialog(null,textMenu);
		if(response == null) response = "0";
		entrada(response);
	    principal();
	}	
	

}
