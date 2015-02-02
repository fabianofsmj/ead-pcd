package br.com.ead_pcd.aula6.exemplos;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Servidor {
	public static void main(String[] args){
		try {
			while(true) {
				ServerSocket servidor = new ServerSocket(2014);
				Socket socketCliente = servidor.accept();
				DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
				String comando = dis.readUTF();
				
				switch (comando) {
				case "soma":
					double valor01 = dis.readDouble();
					double valor02 = dis.readDouble();
					dos.writeDouble(valor01 + valor02);
					dos.flush();
					dos.close();
					dis.close();
					socketCliente.close();
					servidor.close();
					dos.flush();
					break;
				case "subtração":
					double sub01 = dis.readDouble();
					double sub02 = dis.readDouble();
					dos.writeDouble(sub01 - sub02);
					dos.flush();
					dos.close();
					dis.close();
					socketCliente.close();
					servidor.close();
					dos.flush();
					break;
				case "multiplicação":
					double mul01 = dis.readDouble();
					double mul02 = dis.readDouble();
					dos.writeDouble(mul01 * mul02);
					dos.flush();
					dos.close();
					dis.close();
					socketCliente.close();
					servidor.close();
					dos.flush();
					break;
				case "divisão":
					int div01 = dis.readInt();
					int div02 = dis.readInt();
					dos.writeInt(div01 / div02);
					dos.flush();
					dos.close();
					dis.close();
					socketCliente.close();
					servidor.close();
					dos.flush();
					break;
				}
			}
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
