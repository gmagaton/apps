package br.com.economico.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "CONTA")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GERADOR_SQ_CONTA", sequenceName = "SQ_CONTA")
public class Conta extends Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_CONTA")
	@Column(name = "ID")
	private final Integer id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO")
	private ContaTipo tipo;

	Conta() {
		super();
		id = null;
	}

	public Conta(final String descricao, final ContaTipo tipo) {
		this();
		this.descricao = descricao;
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getId() {
		return id;
	}

	public ContaTipo getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTipo(ContaTipo tipo) {
		this.tipo = tipo;
	}

}
