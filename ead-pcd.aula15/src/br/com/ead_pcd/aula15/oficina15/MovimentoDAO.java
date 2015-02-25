package br.com.ead_pcd.aula15.oficina15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MovimentoDAO implements DAOGenerico {

	private Connection conexao = null;
	private Statement sentenca;
	private Movimento movimento;
	private String usuarioBanco = "root";
	private String senhaBanco = "root";
	private String url = "jdbc:mysql://localhost:3306/SGF";
	private String driver = "com.mysql.jdbc.Driver";
	private static Scanner entrada;
	
	public static void main(String[] args) throws ParseException {
		entrada = new Scanner(System.in);
		Movimento movimento = new Movimento();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		MovimentoDAO movimentoDAO = new MovimentoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		int opcao = -1;

		do {
			menu();
			opcao = entrada.nextInt(); 
			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do movimento:");
				movimento.setId(entrada.nextInt());
				System.out.println("Digite o ID do usuario:");
				movimento.setUsuario((Usuario) usuarioDAO.buscarPorId(entrada.nextInt()));
				System.out.println("Digite o ID da categoria:");
				movimento.setCategoria((Categoria) categoriaDAO.buscarPorId(entrada.nextInt()));
				System.out.println("Digite a DATA do movimento. Exemplo: dd/mm/yyyy:");
				movimento.setDataMovimento(new java.sql.Date(format.parse(entrada.next()).getTime()));
				System.out.println("Digite o DEBITO do movimento:");
				movimento.setDebito(entrada.nextBoolean());
				System.out.println("Digite o VALOR do movimento:");
				movimento.setValor(entrada.nextDouble());
				System.out.println("Digite o COMENTARIO do movimento:");
				movimento.setComentario(entrada.next());
				movimentoDAO.inserir(movimento);
				break;
			case 2:
				System.out.println("Digite o ID do movimento:");
				movimento = (Movimento) movimentoDAO.buscarPorId(entrada.nextInt());
				
				if (movimento != null) {
					movimento.setId(movimento.getId());
					System.out.println("Digite o ID do usuario:");
					movimento.setUsuario((Usuario) usuarioDAO.buscarPorId(entrada.nextInt()));
					System.out.println("Digite o ID da categoria:");
					movimento.setCategoria((Categoria) categoriaDAO.buscarPorId(entrada.nextInt()));
					System.out.println("Digite a DATA do movimento. Exemplo: dd/mm/yyyy:");
					movimento.setDataMovimento(new java.sql.Date(format.parse(entrada.next()).getTime()));
					System.out.println("Digite o DEBITO do movimento:");
					movimento.setDebito(entrada.nextBoolean());
					System.out.println("Digite o VALOR do movimento:");
					movimento.setValor(entrada.nextDouble());
					System.out.println("Digite o COMENTARIO do movimento:");
					movimento.setComentario(entrada.next());
					movimentoDAO.atualizar(movimento);				
				} else {
					System.out.println("Movimento não localizado!");
				}
				break;
			case 3:
				System.out.println("Digite o ID do movimento:");
				movimento = (Movimento) movimentoDAO.buscarPorId(entrada.nextInt());
				
				if (movimento != null) {
					movimentoDAO.excluir(movimento.getId());					
				} else {
					System.out.println("Movimento não localizado!");
				}
				break;
			case 4:
				System.out.println("Digite o ID do movimento:");
				movimento = (Movimento) movimentoDAO.buscarPorId(entrada.nextInt());
				if (movimento != null) {
					System.out.println("Movimento consultado com sucesso:\n ID: " + movimento.getId() + "\n Usuario: " + movimento.getUsuario().getIdUsuario() + "\n Categoria: " + movimento.getCategoria().getId() + "\n Data Movimento: " + movimento.getDataMovimento().toString() + "\n Debito: " + movimento.getDebito() + "\n Valor: " + movimento.getValor() + "\n Comentario: " + movimento.getComentario());
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
		System.out.println(" 1. Inserir Movimento\n 2. Atualizar Movimento\n 3. Excluir Movimento\n 4. Buscar Movimento por ID\n 5. Sair\n");
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
			movimento = (Movimento) object;
			String query = "INSERT INTO movimento (id_movimento, id_usuario, id_categoria, data_movimento, debito, valor, comentario) VALUES (" + movimento.getId() + ", " + movimento.getUsuario().getIdUsuario() + ", " + movimento.getCategoria().getId() + ", '" + movimento.getDataMovimento().toString() + "', " + movimento.getDebito() + ", " + movimento.getValor() + ", '" + movimento.getComentario() + "');";
			sentenca.execute(query);
			System.out.println("Movimento inserido com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao inserir movimento: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean atualizar(Object object) {
		criarConexao();
		try {
			movimento = (Movimento) object;
			String query = "UPDATE movimento SET id_usuario=" + movimento.getUsuario().getIdUsuario() + ", id_categoria=" + movimento.getCategoria().getId() + ", data_movimento='" + movimento.getDataMovimento().toString() + "', debito=" + movimento.getDebito() + ", valor=" + movimento.getValor() + ", comentario='" + movimento.getComentario() + "' WHERE id_movimento=" + movimento.getId() + ";";
			sentenca.executeUpdate(query);
			System.out.println("Movimento " + movimento.getId() + " atualizada com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao atualizar movimento: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean excluir(int id) {
		criarConexao();
		try {
			String query = "DELETE FROM movimento WHERE id_movimento=" + id + ";";
			sentenca.execute(query);
			System.out.println("Movimento excluido com sucesso!");
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir movimento: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return false;
	}

	@Override
	public Object buscarPorId(int id) {
		criarConexao();
		try {
			String query = "SELECT * FROM movimento WHERE id_movimento=" + id + ";";
			ResultSet rs = sentenca.executeQuery(query);
			
			while(rs.next()) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				CategoriaDAO categoriaDAO = new CategoriaDAO();
				Movimento movimentoTemp = new Movimento();
				movimentoTemp.setId(rs.getInt("id_movimento"));
				movimentoTemp.setUsuario((Usuario) usuarioDAO.buscarPorId(rs.getInt("id_usuario")));
				movimentoTemp.setCategoria((Categoria) categoriaDAO.buscarPorId(rs.getInt("id_categoria")));
				Date dataMovimento = rs.getDate("data_movimento");
				movimentoTemp.setDataMovimento(dataMovimento);
				movimentoTemp.setDebito(rs.getBoolean("debito"));
				movimentoTemp.setValor(rs.getDouble("valor"));
				movimentoTemp.setComentario(rs.getString("comentario"));
				
				return movimentoTemp;	
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao buscar categoria: " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return null;
	}
}
