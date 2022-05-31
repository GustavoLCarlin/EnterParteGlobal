package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Email;

public class AtualizarEmail {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin(); 

		Email email = em.find(Email.class, 1L);
		
		System.out.println("Email antigo: " + email.getEmail());
		email.setEmail("carlinhos@gmail.com");
		System.out.println("Novo email: " + email.getEmail());

		em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); 
		emf.close();

	}

}
