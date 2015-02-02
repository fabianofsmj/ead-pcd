package br.com.ead_pcd.aula6.video6;

import java.net.*;

/* classe que implementa o Cliente UDP para a aplicação ping-pong.
Observe que o conjunto de classes utilizado é diferente das classes da aplicação TCP*/
public class ClienteUDP {

	public static void main(String[] args) {
		try{
			// criando socket de conexão			
			DatagramSocket socket = new DatagramSocket(5001);
			String att = "Ping";
			byte[] buffer = att.getBytes();

			// Definindo o host (Dispositivo da rede) de acesso
			InetAddress host = InetAddress.getByName("localhost");
			
			DatagramPacket dg = new DatagramPacket(buffer, buffer.length, host, 5000);
			
			socket.send(dg); // Enviando o ping para o servidor
			
			buffer = new byte[50];
			DatagramPacket dg2 = new DatagramPacket(buffer, 50);
			socket.receive(dg2); // Recebendo o pong
			
			String s = new String(dg2.getData()); 
			System.out.println(s); // Imprimindo o pong
			
			socket.close(); // Fechando o socket de conexão
			
		}catch(Exception e){
			System.out.println("erro");
		}
	}
}
