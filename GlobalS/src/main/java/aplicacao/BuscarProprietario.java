package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Proprietario;

public class BuscarProprietario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		Proprietario proprietario = em.find(Proprietario.class, 1L);
		
		System.out.println("Proprietário: " + proprietario.getNome());
		
		System.out.println("pronto!");
		em.close(); 
		emf.close();


	}

}
