package br.com.ead_pcd.aula1.video1;
public class Ciclista {
	private String modalidade;

	// criar o construtor para inicializar todos os atributos

	// criar getters e setters para os atributos

	public void pedalar(){
		System.out.println("Atleta pedalando");
	}
	
	public void setModalidade(String modalidade){
		this.modalidade = modalidade;
	}
	
	public String getModalidade(){
		return modalidade;
	}
}