package dominio;

import java.util.GregorianCalendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gcd_proprietario")
public class Proprietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nm_proprietario",length = 100, nullable = false)
	private String nome;
	
	@Column(name = "nm_apelido",length = 50)
	private String apelido;
	
	@Column(name = "dt_nasc", nullable = false)
	private GregorianCalendar nascimento;
	
	@Column(name = "nr_cpf",length = 12)
	private String cpf;
	
	@Column(name = "nr_rg",length = 11)
	private String rg;
	
	@Column(name = "nm_digit_rg",length = 1)
	private String digitoRg;
	
	@Column(name = "st_genero_biologico",length = 1)
	private String genero;
	
	@Column(name = "st_proprietario",length = 1)
	private String status;
	
	@Column(name = "dt_cadastro", nullable = false)
	private GregorianCalendar dataCadastro;
	
	public Proprietario() {
	}

	public Proprietario( String nome, String apelido, GregorianCalendar nascimento, String cpf, String rg,
			String digitoRg, String genero, String status, GregorianCalendar dataCadastro) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.digitoRg = digitoRg;
		this.genero = genero;
		this.status = status;
		this.dataCadastro = dataCadastro;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public GregorianCalendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(GregorianCalendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDigitoRg() {
		return digitoRg;
	}

	public void setDigitoRg(String digitoRg) {
		this.digitoRg = digitoRg;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GregorianCalendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(GregorianCalendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apelido, codigo, cpf, dataCadastro, digitoRg, genero, nascimento, nome, rg, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietario other = (Proprietario) obj;
		return Objects.equals(apelido, other.apelido) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(digitoRg, other.digitoRg) && Objects.equals(genero, other.genero)
				&& Objects.equals(nascimento, other.nascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(rg, other.rg) && Objects.equals(status, other.status);
	}

	
	
}
