package aula04;

public class ItemNotaFiscal {
	private int item;
	private int quantidade;
	private Produto produto;

	public ItemNotaFiscal() {
	}
	
	public ItemNotaFiscal(int item, int quantidade, Produto produto) {
		this.item = item;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public float valorItem() {
		float valorItem = this.quantidade * this.produto.getValor(); // O valor do produto é encontrado através do método getValor() da classe Produto
		return valorItem;
	}

	public String toString() {
		return "Item: " + this.item + ", Produto: " + produto.getDescricao() + ", Quantidade: " + this.quantidade;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
