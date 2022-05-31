package aplicacao;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Email;
import dominio.Imagem;
import dominio.Proprietario;

public class Programa {
	public static void main(String[] args) throws IOException {
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();

		Path path = FileSystems.getDefault().getPath("img/ix35.jpg");
		byte[] foto = Files.readAllBytes(path);
		
		em.getTransaction().begin();
		
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Joao Pedro");
		proprietario.setApelido("Joaozinho");
		proprietario.setNascimento(new GregorianCalendar(2002, 12, 10));
		proprietario.setCpf("12345678912");
		proprietario.setRg("1234567891");	
		proprietario.setDigitoRg("9");
		proprietario.setGenero("M");
		proprietario.setStatus("A");
		proprietario.setDataCadastro(new GregorianCalendar(2022, 1, 8));
		
		em.persist(proprietario);
		System.out.println("Tabela Proprietario criada!");
		
		Imagem imagem = new Imagem();
		imagem.setProprietario(proprietario);
		imagem.setImgProprietario(foto);
		imagem.setInicio(new GregorianCalendar(2022, 02, 11));
		imagem.setTermino(new GregorianCalendar(2022, 03, 20));
		
		Imagem imagem2 = new Imagem();
		imagem2.setProprietario(proprietario);
		imagem2.setImgProprietario(foto);
		imagem2.setInicio(new GregorianCalendar(2021, 10, 11));
		imagem2.setTermino(new GregorianCalendar(2021, 11, 27));
		
		em.persist(imagem);
		em.persist(imagem2);
		System.out.println("Tabela Imagem criada!");
		
		Email email = new Email();
		email.setProprietario(proprietario);
		email.setEmail("joaozinho@gmail.com");
		email.setStatus("A");
		
		em.persist(email);
		System.out.println("Tabela email criada!");
		
		em.getTransaction().commit();
		System.out.println("pronto!");
		em.close();
		emf.close();
	}
}
