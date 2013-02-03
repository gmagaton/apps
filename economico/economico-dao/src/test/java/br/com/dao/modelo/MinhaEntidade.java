package br.com.dao.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MINHA_ENTIDADE")
public class MinhaEntidade extends Entidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String descricao;
    private boolean ativo;

    MinhaEntidade() {
	super();
    }

    public MinhaEntidade(final Integer id, final String descricao, final boolean ativo) {
	super();
	this.id = id;
	this.descricao = descricao;
	this.ativo = ativo;
    }

    public MinhaEntidade(final String descricao, final boolean ativo) {
	this(null, descricao, ativo);
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
	final MinhaEntidade other = (MinhaEntidade) obj;
	if (ativo != other.ativo) {
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (ativo ? 1231 : 1237);
	return result;
    }

    public boolean isAtivo() {
	return ativo;
    }

    public void setAtivo(final boolean ativo) {
	this.ativo = ativo;
    }

    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }

    public void setId(final Integer id) {
	this.id = id;
    }

}
