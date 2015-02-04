package br.com.ead_pcd.aula12.video12;

import java.util.Iterator;
import java.util.List;

public class Execucao {
	public static void main(String[] args) {
		EmpregadoDAO empregadoDAO = new EmpregadoDAO();

/*		Empregado empregado = new Empregado("Ana", "Mensal", 40);
		
		empregado.setSalario(10000.0);
		
		boolean result = empregadoDAO.inserir(empregado);
		if (result) {
			System.out.println("A Inserção ocorreu com sucesso");
		} else {
			System.out.println("Ocorreu um erro");
		} 
*/
		
/*		Empregado empregado = (Empregado) empregadoDAO.buscarPorId(3);
		System.out.println(empregado.getNome());
*/
	
/*		Empregado empregado = new Empregado("Ana", "Semanl", 20);
		empregado.setId(3);
		
		boolean result = empregadoDAO.atualizar(empregado);
		if (result) {
			System.out.println("Atualizado com sucesso");
		} else {
			System.out.println("Erro na atualização");
		}
*/		
		
/*		boolean result = empregadoDAO.excluir(3);
		if (result) {
			System.out.println("Exclusão realizada com sucesso");
		} else {
			System.out.println("Erro na Exclusão");
		} 
*/		
		
		Empregado empregado;
		List<Empregado> empregados = empregadoDAO.executaJPQL();
		Iterator iterator = empregados.iterator();
		
		while(iterator.hasNext()) {
			empregado = (Empregado) iterator.next();
			System.out.println(empregado.getNome());
		}
		
		
	}

}
