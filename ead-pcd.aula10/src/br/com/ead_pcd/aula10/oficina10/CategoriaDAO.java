package br.com.ead_pcd.aula10.oficina10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CategoriaDAO implements DAOGenerico {

	private Connection conexao = null;
	private Statement sentenca;
	private Categoria categoria;
	private String usuarioBanco = "root";
	private String senhaBanco = "root";
	private String url = "jdbc:mysql://localhost:3306/SGF";
	private String driver = "com.mysql.jdbc.Driver";
	private static Scanner entrada;
	
	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = new Categoria();
		int opcao = -1;

		do {
			menu();
			opcao = entrada.nextInt(); 
			switch (opcao) {
			case 1:
				System.out.println("Digite o ID da categoria:");
				categoria.setId(entrada.nextInt());
				System.out.println("Digite a SIGLA da categoria:");
				categoria.setSigla(entrada.next());
				System.out.println("Digite a DESCRICAO da categoria:");
				categoria.setDescricao(entrada.next());
				System.out.println("Digite o ICONE da categoria:");
				categoria.setIcone(entrada.next());
				categoriaDAO.inserir(categoria);
				break;
			case 2:
				System.out.println("Digite o ID da categoria:");
				categoria = (Categoria) categoriaDAO.buscarPorId(entrada.nextInt());
				
				if (categoria != null) {
					categoria.setId(categoria.getId());
					System.out.println("Digite a SIGLA da categoria:");
					categoria.setSigla(entrada.next());
					System.out.println("Digite a DESCRICAO da categoria:");
					categoria.setDescricao(entrada.next());
					System.out.println("Digite o ICONE da categoria:");
					categoria.setIcone(entrada.next());
					categoriaDAO.atualizar(categoria);
				} else {
					System.out.println("Categoria não localizada!");
				}
				break;
			case 3:
				System.out.println("Digite o ID da categoria:");
				categoria = (Categoria) categoriaDAO.buscarPorId(entrada.nextInt());
				
				if (categoria != null) {
					categoriaDAO.excluir(categoria.getId());
				} else {
					System.out.println("Categoria não localizada!");
				}
				break;
			case 4:
				System.out.println("Digite o ID da categoria:");
				categoria = (Categoria) categoriaDAO.buscarPorId(entrada.nextInt());
				if (categoria != null) {
					System.out.println("Categoria consultada com sucesso:\n ID: " + categoria.getId() + "\n SIGLA: " + categoria.getSigla() + "\n Descricao: " + categoria.getDescricao() + "\n Icone: " + categoria.getIcone());
				} else {
					System.out.println("Categoria n�o localizada!");
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
		System.out.println(" 1. Inserir Categoria\n 2. Atualizar Categoria\n 3. Excluir Categoria\n 4. Buscar Categoria por ID\n 5. Sair\n");
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
			categoria = (Categoria) object;
			String query = "INSERT INTO categoria (id_categoria, sigla, descricao, icone) VALUES (" + categoria.getId() + ", '" + categoria.getSigla() + "', '" + categoria.getDescricao() + "', '" + categoria.getIcone() + "');";
			sentenca.execute(query);
			System.out.println("Categoria inserida com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao inserir categoria: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean atualizar(Object object) {
		criarConexao();
		try {
			categoria = (Categoria) object;
			String query = "UPDATE categoria SET sigla='" + categoria.getSigla() + "', descricao='" + categoria.getDescricao() + "', icone='" + categoria.getIcone() + "' WHERE id_categoria=" + categoria.getId() + ";";
			sentenca.executeUpdate(query);
			System.out.println("Categoria " + categoria.getId() + " atualizada com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao atualizar categoria: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean excluir(int id) {
		criarConexao();
		try {
			String query = "DELETE FROM categoria WHERE id_categoria=" + id + ";";
			sentenca.execute(query);
			System.out.println("Categoria excluida com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir categoria: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public Object buscarPorId(int id) {
		criarConexao();
		try {
			String query = "SELECT * FROM categoria WHERE id_categoria=" + id + ";";
			ResultSet rs = sentenca.executeQuery(query);
			
			while(rs.next()) {
				Categoria categoriaTemp = new Categoria();
				categoriaTemp.setId(rs.getInt("id_categoria"));
				categoriaTemp.setSigla(rs.getString("sigla"));
				categoriaTemp.setDescricao(rs.getString("descricao"));
				categoriaTemp.setIcone(rs.getString("icone"));
				
				return categoriaTemp;	
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao buscar categoria: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return null;
	}
}
