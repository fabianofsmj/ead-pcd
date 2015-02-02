package br.com.ead_pcd.aula6.exemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("127.0.0.1", 2014);
			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Digite o nome da função: \nExemplo: soma, subtração, multiplicação e divisão");
			String comando = entrada.next();
			
			
			switch (comando) {
			case "soma":
				System.out.println("Digite o primeiro valor:");
				double valor01 = entrada.nextDouble();
				System.out.println("Digite o segundo valor:");
				double valor02 = entrada.nextDouble();
				dos.writeUTF(comando);
				dos.writeDouble(valor01);
				dos.flush();
				dos.writeDouble(valor02);
				dos.flush();
				double resultadoSoma = dis.readDouble();
				System.out.println("O resultado da soma é: " + resultadoSoma);
				break;
			case "subtração":
				System.out.println("Digite o primeiro valor:");
				double sub01 = entrada.nextDouble();
				System.out.println("Digite o segundo valor:");
				double sub02 = entrada.nextDouble();
				dos.writeUTF(comando);
				dos.writeDouble(sub01);
				dos.flush();
				dos.writeDouble(sub02);
				dos.flush();
				double resultadoSub = dis.readDouble();
				System.out.println("O resultado da subtração é: " + resultadoSub);
				break;
			case "multiplicação":
				System.out.println("Digite o primeiro valor:");
				double mul01 = entrada.nextDouble();
				System.out.println("Digite o segundo valor:");
				double mul02 = entrada.nextDouble();
				dos.writeUTF(comando);
				dos.writeDouble(mul01);
				dos.flush();
				dos.writeDouble(mul02);
				dos.flush();
				double resultadoMul = dis.readDouble();
				System.out.println("O resultado da multiplicação é: " + resultadoMul);
				break;
			case "divisão":
				System.out.println("Digite o primeiro valor:");
				int div01 = entrada.nextInt();
				System.out.println("Digite o segundo valor:");
				int div02 = entrada.nextInt();
				dos.writeUTF(comando);
				dos.writeInt(div01);
				dos.flush();
				dos.writeInt(div02);
				dos.flush();
				int resultadoDiv = dis.readInt();
				System.out.println("O resultado da divisão é: " + resultadoDiv);
				break;
			default:
				System.exit(0);
				break;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
