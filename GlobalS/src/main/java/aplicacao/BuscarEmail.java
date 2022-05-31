package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Email;

public class BuscarEmail {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		Email email = em.find(Email.class, 1L);
		
		System.out.println("Email: " + email.getEmail());
		
		System.out.println("pronto!");
		em.close(); 
		emf.close();


	}

}
