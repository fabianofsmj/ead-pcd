package br.com.ead_pcd.aula15.oficina15;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="NOME", length=100, nullable=false)
	private String nome;
	
	@Column(name="LOGIN", length=15, nullable=false)
	private String login;
	
	@Column(name="SENHA", length=15, nullable=false)
	private String senha;
	
	@Column(name="ULTIMO_ACESSO", nullable=true)
	@Temporal(TemporalType.DATE)
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
