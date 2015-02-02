package br.com.ead_pcd.aula10.oficina10;

public class Categoria {
	private int id;
	private String sigla;
	private String descricao;
	private String icone;
	
	public Categoria(){
		
	}
	
	public Categoria(int id, String sigla, String descricao, String icone) {
		this.id = id;
		this.sigla = sigla;
		this.descricao = descricao;
		this.icone = icone;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getIcone() {
		return icone;
	}
	
	public void setIcone(String icone) {
		this.icone = icone;
	}
}
