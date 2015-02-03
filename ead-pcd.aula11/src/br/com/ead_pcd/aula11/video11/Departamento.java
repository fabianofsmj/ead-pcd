package br.com.ead_pcd.aula11.video11;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CODIGO", length=12, nullable=true)
	private String codigo;
	
	@Column(name="NOME", length=60, nullable=true)
	private String nome;
	
	@OneToMany(mappedBy="departamento")
	private Collection<Empregado> empregados;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Empregado> getEmpregados() {
		return empregados;
	}
	
	public void setEmpregados(Collection<Empregado> empregados) {
		this.empregados = empregados;
	}
}
