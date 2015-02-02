package br.com.ead_pcd.aula1.video1;
public class Pessoa {
	private String nome;
	private String corDaPele;
	private String camisa;
	private String calca;
	private String sapato;
	private String olhos;
	private String cabelo;

	// criar o construtor para inicializar todos os atributos

	public void andar() {
		System.out.println("Pessoa andando!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCorDaPele() {
		return corDaPele;
	}

	public void setCorDaPele(String corDaPele) {
		this.corDaPele = corDaPele;
	}

	public String getCamisa() {
		return camisa;
	}

	public void setCamisa(String camisa) {
		this.camisa = camisa;
	}

	public String getCalca() {
		return calca;
	}

	public void setCalca(String calca) {
		this.calca = calca;
	}

	public String getSapato() {
		return sapato;
	}

	public void setSapato(String sapato) {
		this.sapato = sapato;
	}

	public String getOlhos() {
		return olhos;
	}

	public void setOlhos(String olhos) {
		this.olhos = olhos;
	}

	public String getCabelo() {
		return cabelo;
	}

	public void setCabelo(String cabelo) {
		this.cabelo = cabelo;
	}

	// criar getters e setters para os atributos
}