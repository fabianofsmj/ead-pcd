package br.com.ead_pcd.aula5.part2.exemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	public static void main(String[] args){
		try {
			File f = new File("F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\dados.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String linha = null;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			
			br.close();
		} catch (IOException ioe) {
			System.out.println("# Ocorreu um erro durante a leitura do arquivo.");
			ioe.printStackTrace();
		}
	}
}
