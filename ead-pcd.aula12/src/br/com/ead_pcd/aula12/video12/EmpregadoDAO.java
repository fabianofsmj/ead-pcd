package br.com.ead_pcd.aula12.video12;

import java.util.List;

import javax.persistence.*;

public class EmpregadoDAO implements DAOGenerico {

	@Override
	public boolean inserir(Object object) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA INSERÇÃO ########
			Empregado empregado = (Empregado) object;
			em.persist(empregado);
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA INSERÇÃO ########
			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object buscarPorId(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		// ######## IMPLEMENTAÇÃO ESPECÍFICA DA BUSCA ########
		Empregado empregado = em.find(Empregado.class, id);
		// ######## IMPLEMENTAÇÃO ESPECÍFICA DA BUSCA ########
		
		em.getTransaction().commit();
		em.close();
		return (empregado);
	}

	@Override
	public boolean atualizar(Object object) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA ATUALIZAÇÃO ########
			Empregado atualizado = (Empregado) object;
			Empregado empregado = em.find(Empregado.class, atualizado.getId());
			em.merge(atualizado);
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA ATUALIZAÇÃO ########
			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean excluir(int id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA EXCLUSÃO ########
			Empregado empregado = em.find(Empregado.class, id);
			em.remove(empregado);
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DA EXCLUSÃO ########
			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Empregado> executaJPQL() {
		List<Empregado> empregados = null;
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DE EXECUÇÃO JPQL ########
/*			Query query = em.createQuery("SELECT e FROM Empregado e WHERE e.salario > 1000");
			empregados = (List<Empregado>) query.getResultList();
*/			
/*			empregados = em.createNamedQuery("empregadoSalarioMaiorMil").getResultList();
 */
			empregados = em.createNamedQuery("empregadoSalarioEntre500E1000").getResultList();
			// ######## IMPLEMENTAÇÃO ESPECÍFICA DE EXECUÇÃO JPQL ########
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (empregados);
	}

}
