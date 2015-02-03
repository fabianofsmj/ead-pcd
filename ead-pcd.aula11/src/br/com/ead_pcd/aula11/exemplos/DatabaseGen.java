package br.com.ead_pcd.aula11.exemplos;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Aula11PU", config);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

}
