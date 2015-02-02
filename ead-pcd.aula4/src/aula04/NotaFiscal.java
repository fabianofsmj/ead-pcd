package aula04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class NotaFiscal {
	private int codigo;
	private Date data;
	private Cliente cliente;
	private List<ItemNotaFiscal> itens = new ArrayList<ItemNotaFiscal>();

	public NotaFiscal() {
	}
	
	public NotaFiscal(int codigo, Date data, Cliente cliente) {
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
	}

	public float calcularValor() {
		float valor = 0;
		
		for (int i = 0; i < itens.size(); i++) {
			valor += itens.get(i).getQuantidade() * itens.get(i).getProduto().getValor();
		}
		
		return valor;
	}

	public void inserirItem(ItemNotaFiscal item) {
		this.itens.add(item);
	}

	public String toString() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return "Código: " + this.codigo + ", Data: " + dataFormatada.format(this.data);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemNotaFiscal> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscal> itens) {
		this.itens = itens;
	}
}