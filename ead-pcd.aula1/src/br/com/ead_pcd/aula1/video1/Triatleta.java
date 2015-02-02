package br.com.ead_pcd.aula1.video1;

public class Triatleta extends Pessoa implements Natacao, Ciclismo, Corrida{
	private String categoria;

	// criar construtor para inicializar os atributos

	public void correr(){
		System.out.println("Triatleta correndo");
	}

	public void pedalar(){
		System.out.println("Triatleta pedalando");
	}

	public void nadarCrawl(){
		System.out.println("Triatleta nadando Crawl");
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void nadarCosta(){
		System.out.println("Triatleta nadando Costa");
	}

	@Override
	public void pedalar(Bicicleta b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nadarCostas() {
		// TODO Auto-generated method stub
		
	}

	// criar getters e setters para os atributos
}