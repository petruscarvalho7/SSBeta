package br.com.sara.entidade;

import java.io.Serializable;

public class Constantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static class Discipulador
	{	
	
	
		private String nome;
	
		public Discipulador(String nome){
			this.nome = nome;
		}
	
		public String getNome(){
			return this.nome;
		}
	
	}
	public Discipulador[] getDiscipuladores(){
		String[] vet ={"Diego","Camila","Pastor","Teste"};
		Discipulador[] discipuladores = new Discipulador[vet.length];
		for(int i=0;i<vet.length;i++){
			discipuladores[i] = new Discipulador(vet[i]);
		}
		return discipuladores;
	}
}

