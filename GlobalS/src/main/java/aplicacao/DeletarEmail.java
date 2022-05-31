package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Email;

public class DeletarEmail {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Email email = em.find(Email.class, 1L);
		em.remove(email);
		
		em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); 
		emf.close();

	}

}
