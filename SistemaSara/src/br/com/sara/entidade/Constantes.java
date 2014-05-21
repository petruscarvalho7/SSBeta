package br.com.sara.entidade;

public class Constantes {

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

