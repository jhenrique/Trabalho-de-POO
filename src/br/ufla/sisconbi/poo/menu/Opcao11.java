/** Classe para executar a opção 11 do Menu
 * @author José Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */
package br.ufla.sisconbi.poo.menu;


import br.ufla.sisconbi.poo.model.Biblioteca;

import br.ufla.sisconbi.poo.model.Publicacao;

public class Opcao11 extends Menu{

	@Override
	public void executa(Biblioteca biblioteca) {
		resposta = input("Digite o titulo do Livro a ser pesquisado");
		Publicacao publicacao = biblioteca.pesquisaLivroPor(resposta);
		notNull("Livro", publicacao);
		outputMessage(publicacao.toString());
	}

}
