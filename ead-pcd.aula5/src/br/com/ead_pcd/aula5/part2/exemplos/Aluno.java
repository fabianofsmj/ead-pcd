package br.com.ead_pcd.aula5.part2.exemplos;

import java.io.Serializable;

public class Aluno implements Serializable{
	private String matricula;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Aluno(String matricula, String nome){
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}
	
}
