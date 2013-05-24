package br.com.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

public class Master implements Serializable {

    private static final long serialVersionUID = 279187507657541363L;

    private Integer id;

    @Size(min = 5, max = 60)
    private String descricao;

    private Status status = Status.ATIVO;

    private final List<Detail> detalhes = new ArrayList<Detail>();

    public Master() {
	super();
    }

    public Master(final Integer id, final String descricao) {
	super();
	setId(id);
	this.descricao = descricao;
    }

    public void addDetalhe(final Detail detail) {
	if (detail != null) {
	    detalhes.add(detail);
	}
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
	final Master other = (Master) obj;
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

    public List<Detail> getDetalhes() {
	return detalhes;
    }

    public Integer getId() {
	return id;
    }

    public Status getStatus() {
	return status;
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

    public void setDetalhes(final List<Detail> detalhes) {
	if (detalhes == null) {
	    this.detalhes.clear();
	    return;
	}
	if (detalhes.size() > 0) {
	    this.detalhes.clear();
	    this.detalhes.addAll(detalhes);
	}
    }

    public void setStatus(final Status status) {
	this.status = status;
    }

    public static List<Master> listaFake() {
	final List<Master> lista = new ArrayList<Master>();

	for (int i = 1; i <= 10; i++) {
	    final Master m = new Master(i, "MASTER " + i);
	    for (int j = 1; j <= 10; j++) {
		final Detail d = new Detail(j, "DETALHE " + j, m);
		m.addDetalhe(d);
	    }
	    lista.add(m);
	}

	return lista;
    }

    public void setId(final Integer id) {
	this.id = id;
    }
}
