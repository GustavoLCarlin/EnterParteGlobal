package dominio;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "t_gcd_prop_imagem")
public class Imagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_proprietario",nullable = false)
	private Proprietario proprietario;
	
	@Lob
	@Column(name = "img_proprietario", nullable = false)
	private byte[] imgProprietario;
	
	@Column(name = "dt_inicio", nullable = false)
	private GregorianCalendar inicio;
	
	@Column(name = "dt_termino")
	private GregorianCalendar termino;

	public Imagem() {
	}

	public Imagem( Proprietario proprietario, byte[] imgProprietario, GregorianCalendar inicio,
			GregorianCalendar termino) {
		super();
		this.proprietario = proprietario;
		this.imgProprietario = imgProprietario;
		this.inicio = inicio;
		this.termino = termino;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public byte[] getImgProprietario() {
		return imgProprietario;
	}

	public void setImgProprietario(byte[] imgProprietario) {
		this.imgProprietario = imgProprietario;
	}

	public GregorianCalendar getInicio() {
		return inicio;
	}

	public void setInicio(GregorianCalendar inicio) {
		this.inicio = inicio;
	}

	public GregorianCalendar getTermino() {
		return termino;
	}

	public void setTermino(GregorianCalendar termino) {
		this.termino = termino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imgProprietario);
		result = prime * result + Objects.hash(codigo, inicio, proprietario, termino);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagem other = (Imagem) obj;
		return Objects.equals(codigo, other.codigo) && Arrays.equals(imgProprietario, other.imgProprietario)
				&& Objects.equals(inicio, other.inicio) && Objects.equals(proprietario, other.proprietario)
				&& Objects.equals(termino, other.termino);
	}
	
	
}
