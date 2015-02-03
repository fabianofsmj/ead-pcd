package br.com.ead_pcd.aula11.video11;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Empregado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CPF", length=11, nullable=true)
	private String cpf;
	
	@Column(name="NOME", length=60, nullable=true)
	private String nome;
	
	@Column(name="DATA_NASCIMENTO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="DATA_INGRESSO", nullable=false)
	@Temporal(TemporalType.DATE)	
	private Date dataIngresso;
	
	@Column(name="ESTADO_CIVIL", length=60, nullable=true)
	private String estadoCivil;
	
	@Column(name="FOTO", nullable=true)
	private byte foto;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID", nullable=true)
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name="VAG_ID")
	private VagaEstacionamento vaga;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataIngresso() {
		return dataIngresso;
	}
	
	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public byte getFoto() {
		return foto;
	}
	
	public void setFoto(byte foto) {
		this.foto = foto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public VagaEstacionamento getVaga() {
		return vaga;
	}

	public void setVaga(VagaEstacionamento vaga) {
		this.vaga = vaga;
	}
}
