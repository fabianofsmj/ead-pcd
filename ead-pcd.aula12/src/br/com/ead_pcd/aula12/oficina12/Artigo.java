package br.com.ead_pcd.aula12.oficina12;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Artigo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TITULO", length=20, nullable=false)
	private String titulo;
	
	@Column(name="DATA", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="REV_ID", nullable=false)
	private Revista revista;
	
	@ManyToMany
	@JoinTable(name="ART_AUT",
			joinColumns=@JoinColumn(name="ART_ID"),
			inverseJoinColumns=@JoinColumn(name="ART_ID"))
	private Collection<Autor> autores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public Collection<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
}
