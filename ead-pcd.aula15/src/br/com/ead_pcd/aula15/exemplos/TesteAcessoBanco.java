package br.com.ead_pcd.aula15.exemplos;

import java.sql.DriverManager;
import java.sql.Connection;

public class TesteAcessoBanco {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/SGF";
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
