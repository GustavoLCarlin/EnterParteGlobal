package dominio;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "t_gcd_email")
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_proprietario",nullable = false)
	private Proprietario proprietario;
	
	@Column(name = "ds_email",length = 80, nullable = false)
	private String email;
	
	@Column(name = "st_status",length = 1, nullable = false)
	private String status;

	public Email() {
	}

	public Email(Long codigo, Proprietario proprietario, String email, String status) {
		super();
		this.codigo = codigo;
		this.proprietario = proprietario;
		this.email = email;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, email, proprietario, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(email, other.email)
				&& Objects.equals(proprietario, other.proprietario) && Objects.equals(status, other.status);
	}
	
}
