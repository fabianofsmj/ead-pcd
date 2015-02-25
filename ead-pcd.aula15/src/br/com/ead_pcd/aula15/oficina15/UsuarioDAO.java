package br.com.ead_pcd.aula15.oficina15;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO implements DAOGenerico {

	@Override
	public boolean inserir(Object object) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			Usuario usuario = (Usuario) object;
			em.persist(usuario);
			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean atualizar(Object object) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			Usuario usuarioAtualizado = (Usuario) object;
			Usuario usuario = em.find(Usuario.class, usuarioAtualizado.getIdUsuario());
			em.merge(usuarioAtualizado);
			
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
			
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			
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
		
		Usuario usuario = em.find(Usuario.class, id);
		
		em.getTransaction().commit();
		em.close();
		return (usuario);
	}
}