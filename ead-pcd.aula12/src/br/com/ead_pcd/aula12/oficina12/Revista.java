package br.com.ead_pcd.aula12.oficina12;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name="REVISTA_TIPO")
public abstract class Revista {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TITULO", length=20, nullable=false)
	private String titulo;
	
	@Column(name="DATA_PUBLICACAO", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@OneToMany(mappedBy="revista")
	private Collection<Artigo> artigos;

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

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Collection<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(Collection<Artigo> artigos) {
		this.artigos = artigos;
	}

}
