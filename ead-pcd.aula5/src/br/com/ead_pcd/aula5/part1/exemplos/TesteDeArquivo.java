package br.com.ead_pcd.aula5.part1.exemplos;

import java.io.File;

public class TesteDeArquivo {
	public static void main(String[] args) {
		
		//String enderecoDoArquivo = "D:\\Developer\\projetos\\ead-pcd\\ead-pcd.aula5\\dados.txt";
		String enderecoDoArquivo = "F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\dados.txt";
		File arquivoAlvo = new File(enderecoDoArquivo);
			
		if (arquivoAlvo.exists()) {
			System.out.println("É arquivo? " + (arquivoAlvo.isFile()?"Sim.":"Não."));
			System.out.println("O arquivo tem " + arquivoAlvo.length() + " bytes!");
			System.out.println("Está dentro de " + arquivoAlvo.getParent());
		} else {
			System.out.println("O endereço informado não existe.");
		}
		
	}

}
