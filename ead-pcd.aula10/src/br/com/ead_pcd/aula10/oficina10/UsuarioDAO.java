package br.com.ead_pcd.aula10.oficina10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsuarioDAO implements DAOGenerico {

	private Connection conexao = null;
	private Statement sentenca;
	private Usuario usuario;
	private String usuarioBanco = "root";
	private String senhaBanco = "root";
	private String url = "jdbc:mysql://localhost:3306/SGF";
	private String driver = "com.mysql.jdbc.Driver";
	private static Scanner entrada;
	
	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		int opcao = -1;

		do {
			menu();
			opcao = entrada.nextInt(); 
			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do usuário:");
				usuario.setIdUsuario(entrada.nextInt());
				System.out.println("Digite o NOME do usuário:");
				usuario.setNome(entrada.next());
				System.out.println("Digite o LOGIN do usuário:");
				usuario.setLogin(entrada.next());
				System.out.println("Digite o SENHA do usuário:");
				usuario.setSenha(entrada.next());
				usuarioDAO.inserir(usuario);
				break;
			case 2:
				System.out.println("Digite o ID do usuário:");
				usuario = (Usuario) usuarioDAO.buscarPorId(entrada.nextInt()); 
				
				if (usuario != null) {
					usuario.setIdUsuario(usuario.getIdUsuario());
					System.out.println("Digite o NOME do usuário:");
					usuario.setNome(entrada.next());
					System.out.println("Digite o LOGIN do usuário:");
					usuario.setLogin(entrada.next());
					System.out.println("Digite o SENHA do usuário:");
					usuario.setSenha(entrada.next());
					usuarioDAO.atualizar(usuario);				
				} else {
					System.out.println("Usuário não localizado!");
				}
				break;
			case 3:
				System.out.println("Digite o ID do usuário:");
				usuario = (Usuario) usuarioDAO.buscarPorId(entrada.nextInt());
				
				if (usuario != null) {
					usuarioDAO.excluir(usuario.getIdUsuario());
				} else {
					System.out.println("Usuário não localizado!");
				}
				break;
			case 4:
				System.out.println("Digite o ID do usuário:");
				usuario = (Usuario) usuarioDAO.buscarPorId(entrada.nextInt());
				if (usuario != null) {
					System.out.println("Usuario consultado com sucesso:\n ID: " + usuario.getIdUsuario() + "\n Nome: " + usuario.getNome() + "\n Login: " + usuario.getLogin() + "\n Senha: " + usuario.getSenha() + "\n Ultimo Acesso: " + usuario.getUltimoAcesso());
				} else {
					System.out.println("Usuário não localizado!");
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Opcao invalida!	");
				opcao = -1;
			}
					
		} while (opcao != 5);
	}
	
	private static void menu() {
		System.out.println(":: Menu ::\n");
		System.out.println(" 1. Inserir Usuario\n 2. Atualizar Usuario\n 3. Excluir Usuario\n 4. Buscar Usuario por ID\n 5. Sair\n");
		System.out.print(">> ");
	}

	public void criarConexao(){
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuarioBanco, senhaBanco);
			sentenca = conexao.createStatement();
		} catch(ClassNotFoundException cnfe) {
			throw new RuntimeException(cnfe);
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}
	}
	
	public void fecharConexao() {
		try {
			if (conexao != null) {
				conexao.close();
				sentenca.close();
			}
		} catch (SQLException sqle) {
			
		}
	}
	
	@Override
	public boolean inserir(Object object) {
		criarConexao();
		try {
			usuario = (Usuario) object;
			String query = "INSERT INTO usuario (id_usuario, nome, login, senha) VALUES (" + usuario.getIdUsuario() + ", '" + usuario.getNome() + "', '" + usuario.getLogin() + "', '" + usuario.getSenha() + "');";
			sentenca.execute(query);
			System.out.println("Usuário inserido com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao inserir usuario: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean atualizar(Object object) {
		criarConexao();
		try {
			usuario = (Usuario) object;
			String query = "UPDATE usuario SET nome='" + usuario.getNome() + "', login='" + usuario.getLogin() + "', senha='" + usuario.getSenha() + "' WHERE id_usuario=" + usuario.getIdUsuario() + ";";
			sentenca.executeUpdate(query);
			System.out.println("Usuario " + usuario.getIdUsuario() + " atualizado com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao atualizar usuario: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean excluir(int id) {
		criarConexao();
		try {
			String query = "DELETE FROM usuario WHERE id_usuario=" + id + ";";
			sentenca.execute(query);
			System.out.println("Usuario excluido com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir usuario: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public Object buscarPorId(int id) {
		criarConexao();
		try {
			String query = "SELECT * FROM usuario WHERE id_usuario=" + id + ";";
			ResultSet rs = sentenca.executeQuery(query);
			
			while(rs.next()) {
				Usuario usuarioTemp = new Usuario();
				usuarioTemp.setIdUsuario(rs.getInt("id_usuario"));
				usuarioTemp.setNome(rs.getString("nome"));
				usuarioTemp.setLogin(rs.getString("login"));
				usuarioTemp.setSenha(rs.getString("senha"));
				usuarioTemp.setUltimoAcesso(rs.getDate("ultimo_acesso"));
				
				return usuarioTemp;	
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao buscar usuario: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return null;
	}
}