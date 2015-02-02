package br.com.ead_pcd.aula10.exemplos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlunoDAO implements DAOGenerico {
	
	private Connection conexao;

	public boolean inserir(Object o) {		
		try{
			
			Aluno a = (Aluno)o;
			String query = "INSERT INTO aluno (id, matricula, nome) VALUES (" + 
				a.getId() + ",'" + a.getMatricula() + "','" + a.getNome() + "'"; 
			
			Statement sentenca = conexao.createStatement();
	        sentenca.execute(query);
	        
	        return true;
	        
		}catch (Exception e){
           // Tratamento de exceções ...
       }
       
       return false;
	}

	public boolean atualizar(Object o) {
		try{
			
			Aluno a = (Aluno)o;
			String query = "UPDATE aluno SET matricula = '" + a.getMatricula() + "', nome = '" + a.getNome() + "'"; 
			
			Statement sentenca = conexao.createStatement();
	        sentenca.executeUpdate(query);
	        
	        return true;
	        
		}catch (Exception e){
           // Tratamento de exceções ...
       }
       
       return false;
	}

	public boolean excluir(int id) {
		try{
			
			String query = "DELETE FROM aluno WHERE id = " + id; 
			
			Statement sentenca = conexao.createStatement();
	        sentenca.execute(query);
	        
	        return true;
	        
		}catch (Exception e){
           // Tratamento de exceções ...
       }
       
       return false;
	}

	public Object buscarPorID(int id) {
		try{
			
			String query = "SELECT * FROM aluno WHERE id = " + id; 
			
			Statement sentenca = conexao.createStatement();
	        ResultSet rs = sentenca.executeQuery(query);
	        
	        if(rs.next()){
	        	Aluno a = new Aluno();
	        	a.setId(rs.getInt("id"));
	        	a.setMatricula(rs.getString("matricula"));
	        	a.setNome(rs.getString("nome"));
	        	
	        	return a;
	        }        	        
	        
		}catch (Exception e){
         // Tratamento de exceções ...
    }
       
       return null;
	}

 }