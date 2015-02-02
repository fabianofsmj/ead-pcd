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

// 		1 - Qual a sequência dos elementos exibido na tela pelo item f?
// 		R. Ordem de exibição: D, C, B, A.
//		2 - O que aconteceu com a ordem original dos elementos que foram colocados no mapa? Qual das coleções é responsável por essa mudança?
//		R. A ordem foi invertida, pois, o primeiro elemento que entra na pilha é o último que vai sair e isso fez com que os elementos fossem inseridos na lista de forma invertida também. A coleção responsável por essa alteração foi a Pilha.
		
	}
}
