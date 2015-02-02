package br.com.ead_pcd.aula2.oficina2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Oficina {
	public static void main(String[] args){
		HashMap<String, String> mapa = new HashMap<String, String>();
		Stack pilha = new Stack();
		ArrayList lista = new ArrayList();
		
		mapa.put("A", "Alisson");
		mapa.put("B", "Bianca");
		mapa.put("C", "Carlos");
		mapa.put("D", "Denise");
		
		mapa.remove("A");
		mapa.remove("B");
		mapa.remove("C");
		mapa.remove("D");
		
		pilha.addElement("A");
		pilha.addElement("B");
		pilha.addElement("C");
		pilha.addElement("D");
		
		while(!pilha.isEmpty()){
			lista.add(pilha.pop());
		}
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + " ");
		}

// 		1 - Qual a sequ�ncia dos elementos exibido na tela pelo item f?
// 		R. Ordem de exibi��o: D, C, B, A.
//		2 - O que aconteceu com a ordem original dos elementos que foram colocados no mapa? Qual das cole��es � respons�vel por essa mudan�a?
//		R. A ordem foi invertida, pois, o primeiro elemento que entra na pilha � o �ltimo que vai sair e isso fez com que os elementos fossem inseridos na lista de forma invertida tamb�m. A cole��o respons�vel por essa altera��o foi a Pilha.
		
	}
}
