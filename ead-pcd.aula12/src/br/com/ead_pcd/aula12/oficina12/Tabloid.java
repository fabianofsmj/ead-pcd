package br.com.ead_pcd.aula12.oficina12;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TABLOID")
public class Tabloid extends Revista {
	@Column(name="PERIODICIDADE", nullable=true)
	private int periodicidade;
	
	@Column(name="TEMA", length=20, nullable=true)
	private String tema;

	public int getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
