package br.com.ead_pcd.aula6.video6;

import java.net.*;

/* classe que implementa o servidor UDP para a aplica��o ping-pong.
 Observe que o conjunto de classes utilizado � diferente das classes da aplica��o TCP*/
public class ServidorUDP {
	public static void main(String[] args) {
		try{
			// criando socket de conex�o e definindo o host (Dispositivo da rede) de acesso
			DatagramSocket socketServidor = new DatagramSocket(5000);
			InetAddress host = InetAddress.getByName("localhost"); //  Neste caso, � a pr�pria m�quina que est� executando este programa (localhost)
			
			byte[] buffer = new byte[50];
			DatagramPacket dg = new DatagramPacket(buffer, 50);
			socketServidor.receive(dg); // recebendo o ping
			
			String s = new String(dg.getData()); 
			System.out.println(s); // escrevendo o ping
			
			String att = "Pong";
			buffer = new byte[50];
			buffer = att.getBytes(); 
			DatagramPacket dg2 = new DatagramPacket(buffer, buffer.length, host, 5001);
			
			socketServidor.send(dg2); // Enviando o pong
						
			socketServidor.close(); // Fechando o socket de conex�o
		}catch(Exception e){
			System.out.println("erro");
		}
	}
}
