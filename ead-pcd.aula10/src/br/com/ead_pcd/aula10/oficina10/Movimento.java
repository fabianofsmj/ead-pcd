package br.com.ead_pcd.aula10.oficina10;

import java.util.Date;

public class Movimento {
	private int id;
	private Usuario usuario;
	private Categoria categoria;
	private Date dataMovimento;
	private boolean debito;
	private double valor;
	private String comentario;
	
	public Movimento() {
		
	}
	
	public Movimento(int id, Usuario usuario, Categoria categoria, Date dataMovimento, boolean debito, double valor, String comentario) {
		this.id = id;
		this.usuario = usuario;
		this.categoria = categoria;
		this.dataMovimento = dataMovimento;
		this.debito = debito;
		this.valor = valor;
		this.comentario = comentario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Date getDataMovimento() {
		return dataMovimento;
	}
	
	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	
	public boolean getDebito() {
		return debito;
	}
	
	public void setDebito(boolean debito) {
		this.debito = debito;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}