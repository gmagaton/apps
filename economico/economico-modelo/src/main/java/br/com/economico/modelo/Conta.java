package br.com.economico.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.dao.modelo.Entidade;

@Entity
@Table(name = "CONTA")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GERADOR_SQ_CONTA", sequenceName = "SQ_CONTA")
public class Conta extends Entidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_CONTA")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private ContaTipo tipo;

    @ManyToOne
    @JoinColumn(name = "PERFIL_ID")
    private Perfil perfil;

    Conta() {
	super();
	setId(null);
	setPerfil(null);
    }

    public Conta(final String descricao, final ContaTipo tipo, final Perfil perfil) {
	this();
	this.descricao = descricao;
	this.tipo = tipo;
	this.perfil = perfil;
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Conta other = (Conta) obj;
	if (getId() == null) {
	    if (other.getId() != null) {
		return false;
	    }
	} else if (!getId().equals(other.getId())) {
	    return false;
	}
	return true;
    }

    public String getDescricao() {
	return descricao;
    }

    public Integer getId() {
	return id;
    }

    public Perfil getPerfil() {
	return perfil;
    }

    public ContaTipo getTipo() {
	return tipo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (getId() == null ? 0 : getId().hashCode());
	return result;
    }

    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }

    private void setId(final Integer id) {
	this.id = id;
    }

    public void setPerfil(final Perfil perfil) {
	this.perfil = perfil;
    }

    public void setTipo(final ContaTipo tipo) {
	this.tipo = tipo;
    }

}
