/** Classe para Manipular Entra e Sa�da de Dados
 * @author Jos� Henrique, Lucas Lima, Samuel Giarola
 * @version 2.0
 * */

package br.ufla.sisconbi.poo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public abstract class ManipuladorIO {

	protected ObjectOutputStream arquivoDeSaida; 
	protected ObjectInputStream arquivoDeLeitura;
	private String nomeDoArquivo;
	
	public ManipuladorIO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}
	
	public abstract Object ler () throws FileNotFoundException; 
	
	/**
	 * Método para prepara um Conexão com Leitura
	 * */
	public  void preparaConexaoDeLeitura(){
		
		try {arquivoDeLeitura = new ObjectInputStream(new FileInputStream(nomeDoArquivo +".txt"));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao tentar abrir o arquivo");
		}
	}
	
	/**
	 * Método para preparar Conexão para Gravação
	 * */
	
	public void preparaConexaoParaGravacao() {
		try {arquivoDeSaida = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo +".txt"));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao tentar gravar no arquivo");
		}

	}
	
	public void grava (Object objeto ){
		preparaConexaoParaGravacao();
		try {
			arquivoDeSaida.writeObject(objeto);
			arquivoDeSaida.close();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}


}
