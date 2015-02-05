package br.com.ead_pcd.aula12.oficina12;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOME", length=20, nullable=true)
	private String nome;
	
	@Column(name="TITULACAO", length=20, nullable=true)
	private String titulacao;
	
	@ManyToMany(mappedBy="autores")
	private Collection<Artigo> artigos;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public Collection<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(Collection<Artigo> artigos) {
		this.artigos = artigos;
	}

}
