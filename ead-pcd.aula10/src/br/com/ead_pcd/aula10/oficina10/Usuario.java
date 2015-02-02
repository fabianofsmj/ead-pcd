package br.com.ead_pcd.aula10.oficina10;

import java.util.Date;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private Date ultimoAcesso;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String login, String senha) {
		this.idUsuario = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
}
