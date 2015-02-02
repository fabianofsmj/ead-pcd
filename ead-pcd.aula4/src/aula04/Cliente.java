package aula04;

public class Cliente {
	private int codigo;
	private String cnpj;
	private String nome;

	public Cliente() {
	}
	
	public Cliente(int codigo, String cnpj, String nome) {
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public String toString() {
		return "Código: " + this.codigo + ", Nome: " + this.nome + ", CNPJ: " + this.cnpj;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
