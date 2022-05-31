package aplicacao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dominio.Imagem;

public class BuscarImagem {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GlobalS");
		EntityManager em = emf.createEntityManager();
		
		Imagem imagem = em.find(Imagem.class, 1L);
		
		em.detach(imagem);
		Imagem imagem2 = em.find(Imagem.class, imagem.getCodigo());
		
		if (imagem2.getImgProprietario() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagem2.getImgProprietario()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Proprietario não possui foto.");
		}

		
		System.out.println("pronto!");
		em.close(); 
		emf.close();
	}
}
