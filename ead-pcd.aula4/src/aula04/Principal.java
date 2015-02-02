package aula04;

import java.util.Date;

public class Principal {
	public static void main(String args[]) {
		Cliente cliente = new Cliente(100, "Lanchonete das Coxinhas", "200.890.0001/10");
		
		Produto p1 = new Produto(110, "Milho", 4.00f);
		Produto p2 = new Produto(200, "Arroz", 5.00f);
		Produto p3 = new Produto(250, "Soja", 8.00f);

		// objeto itnf1 -> Atributos item=1, quantidade=10, produto= p1
		ItemNotaFiscal itnf1 = new  ItemNotaFiscal(1,10,p1);
		ItemNotaFiscal itnf2 = new  ItemNotaFiscal(2,10,p2);
		ItemNotaFiscal itnf3 = new  ItemNotaFiscal(3,10,p3);
		
		NotaFiscal nf1 = new NotaFiscal(1, new Date(), cliente);
		nf1.inserirItem(itnf1);
		nf1.inserirItem(itnf2);
		nf1.inserirItem(itnf3);
		
		System.out.println("Dados da Nota: " + nf1.toString());
		System.out.println("Valor total da nota: " + nf1.calcularValor());

	}
}
