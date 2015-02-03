package br.com.ead_pcd.aula11.exemplos;

import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOME", length=60, nullable=true)
	private String nome;
	
	@Column(name="USERNAME", length=20, nullable=true)
	private String username;
	
	@Column(name="PASSWORD", length=8, nullable=true)
	private String password;
	
	@Column(name="EMAIL", length=20, nullable=true)
	private String email;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
