package br.com.ead_pcd.aula12.video12;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="empregadoSalarioMaiorMil", query="SELECT e FROM Empregado e WHERE e.salario > 1000"),
	@NamedQuery(name="empregadoSalarioEntre500E1000", query="SELECT e FROM Empregado e WHERE e.salario BETWEEN 500 AND 1000")
})
public class Empregado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOME", length=60, nullable=true)
	private String nome;
	
	@Column(name="REGIME_DE_TRABALHO", length=20, nullable=true)
	private String regimeDeTrabalho;
	
	@Column(name="CARGA_HORARIA", nullable=true)
	private Integer cargaHoraria;
	
	@Column(name="SEXO", nullable=true)
	private Character sexo;
	
	@Column(name="SALARIO", nullable=true)
	private double salario;
	
	@Column(name="STATUS", nullable=true)
	private Integer status;
	
	@Column(name="PERFIL", nullable=true)
	private Integer perfil;
	
	public Empregado() {

	}
	
	public Empregado(String nome, String regimeDeTrabalho, Integer cargaHoraria) {
		this.nome = nome;
		this.regimeDeTrabalho = regimeDeTrabalho;
		this.cargaHoraria = cargaHoraria;
	}

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

	public String getRegimeDeTrabalho() {
		return regimeDeTrabalho;
	}

	public void setRegimeDeTrabalho(String regimeDeTrabalho) {
		this.regimeDeTrabalho = regimeDeTrabalho;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
}
