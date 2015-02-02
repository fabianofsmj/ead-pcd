package br.com.ead_pcd.aula10.exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteAcessoBanco {
	
	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			String usuario = "root";
			String senha = "root";
			String url = "jdbc:mysql://localhost:3306/escola";
			
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("A conexao esta funcionando!");
			
			
//			Crie um Statement aqui e execute dois comandos SQL:
//			-um para atualizar qualquer registro da tabela aluno
//			Statement atualizacao = conexao.createStatement();
//			atualizacao.executeUpdate("UPDATE aluno SET id = 5 WHERE id = 10");
//			-um para remover um registro da tabela aluno
//			Statement exclusao = conexao.createStatement();
//			exclusao.execute("DELETE FROM aluno WHERE id = 5");
//			Verifique se os resultados correspondem ao esperado
			
			Statement insercao = conexao.createStatement();
			insercao.execute("INSERT INTO aluno (id, matricula, nome) VALUES (10, '99999999', 'Pedro Java')");
			
			Statement sentenca = conexao.createStatement();
			ResultSet rs = sentenca.executeQuery("SELECT id, matricula, nome FROM aluno");
			
			System.out.println("ID\tMATRICULA\tNOME");
			while (rs.next()) {
				int id = rs.getInt("id");
				String matricula = rs.getString("matricula");
				String nome = rs.getString("nome");
				System.out.println(id + "\t" + matricula + "\t" + nome);
			}
			
		} catch (Exception e) {
			System.err.println("Ocorreu um erro na conexao: " + e.getMessage());
		} finally {
			if (conexao != null) {
				try {
					conexao.close();
					System.out.println("Encerrando a conexão!");
				} catch (Exception e) {
					
				}
			}
		}
	}
}
