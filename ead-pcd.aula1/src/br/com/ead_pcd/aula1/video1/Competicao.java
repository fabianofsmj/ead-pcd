package br.com.ead_pcd.aula1.video1;

public class Competicao {
	
	public static void main(String[] args){
		Corredor c1 = new Corredor();
		c1.setMetrosProva(200);
		c1.correr();

		// coloque o seu código aqui
		Ciclista ciclista1 = new Ciclista();
		ciclista1.setModalidade("Adulto");
		ciclista1.pedalar();

		// alterar classe para USA dados de triatleta
	}
}