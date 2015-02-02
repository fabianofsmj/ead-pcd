package br.com.ead_pcd.aula2.video2;

import java.util.HashMap;
import java.util.Scanner;

public class UsandoHashMap {
	public static void main(String[] args){
		HashMap<String, String> hm = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		String entrada;
		String significado;
		
		hm.put("Decência", "Respeito aos bons costumes; reserva; honestidade; dignidade nas maneiras, na linhagem.");
		hm.put("Tabela","Pequena tábua, quadro ou folha de papel, em que são registrados nomes de coisas ou de pessoas.");
		hm.put("Arquivamento", "Ação ou efeito de arquivar; arquivação.");
		hm.put("Sobre", "Denota ou mostra a posição ou a localização daquilo que se encontra acima de; por cima de; em cima de: o livro está sobre a mesa.");
		hm.put("Conceber", "Gerar ou engravidar; dar origem a outro ser humano: o Espírito Santo concebeu a Virgem Maria; a vizinha concebeu do primo; não tinha vontade de conceber.");
		hm.put("Nevralgia", "Medicina. Dor aguda, ocasionada por um dano causado no nervo, que decorre durante todo o seu trajeto e áreas adjacentes em que o mesmo se manifesta.");
		hm.put("Futuridade", "Característica do que pode acontecer ou se realizar no futuro; futuração: mudou seus planos para a futuridade.");
		
		
		System.out.println("Dgite uma palavra para ver o significado:");
		entrada = sc.nextLine();
		significado = hm.get(entrada);
		
		System.out.println("O significado da palavra " + entrada + " é: " + significado);
		
	}

}
