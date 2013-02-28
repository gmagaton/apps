package br.com.economico.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.dao.modelo.Entidade;

@Entity
@Table(name = "PERFIL")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GERADOR_SQ_PERFIL", sequenceName = "SQ_PERFIL")
public class Perfil extends Entidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_PERFIL")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SENHA")
    private String senha;

    Perfil() {
	super();
    }

    public Perfil(final String nome, final String senha) {
	this();
	this.nome = nome;
	this.senha = senha;
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
	final Perfil other = (Perfil) obj;
	if (nome == null) {
	    if (other.nome != null) {
		return false;
	    }
	} else if (!nome.equals(other.nome)) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (nome == null ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public String toString() {
	return "Perfil [id=" + id + ", nome=" + nome + "]";
    }

}
