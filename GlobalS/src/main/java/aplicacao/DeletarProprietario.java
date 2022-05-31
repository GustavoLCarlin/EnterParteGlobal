package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Proprietario;

public class DeletarProprietario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Proprietario proprietario = em.find(Proprietario.class, 1L);
		em.remove(proprietario);
		
		em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); 
		emf.close();
	}

}
