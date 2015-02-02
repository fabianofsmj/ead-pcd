package br.com.ead_pcd.aula5.part2.exemplos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GravarArquivo {
	public static void main(String[] args){
		try {
			File f = new File("F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\dados.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			
			String novoConteudo = "";
			novoConteudo = JOptionPane.showInputDialog(null, "Informe um texto");
			
			bw.write(System.getProperty("line.separator") + novoConteudo);
			bw.flush();
			bw.close();
			
		} catch (IOException ioe) {
			System.out.println("# Ocorreu um erro durante a gravação do arquivo.");
			ioe.printStackTrace();
		}
		
		
	}
}
