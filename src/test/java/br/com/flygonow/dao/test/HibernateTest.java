package br.com.flygonow.dao.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateTest {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("flygonowUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager);

	}

}
