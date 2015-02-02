package br.com.ead_pcd.aula6.exemplos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorResultados {
	private String resultado;
	private String dataSorteio;

	public void iniciarServico(){
		resultado = "06-55-13-47-22-19";
		dataSorteio = "08/10";
		
		try {
			ServerSocket ss = new ServerSocket(2012);
			
			while (true){
				System.out.println("Servidor aguardando conexão...");
				Socket cliente = ss.accept();
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				System.out.println("Enviando dados para " + cliente.getInetAddress());
				dos.writeUTF(resultado + "," + dataSorteio);
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public static void main(String[] args) {
		ServidorResultados sr = new ServidorResultados();
		sr.iniciarServico();
	}
}
