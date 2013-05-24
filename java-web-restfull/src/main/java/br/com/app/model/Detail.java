package br.com.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Detail implements Serializable {

    private static final long serialVersionUID = -6115441806658676655L;

    private final Integer id;
    private String descricao;
    private Status status = Status.ATIVO;

    private Master master;

    Detail() {
        super();
        id = null;
    }

    public Detail(final Integer id, final String descricao) {
        super();
        this.id = id;
        this.descricao = descricao;
    }

    public Detail(final Integer id, final String descricao, final Master master) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.master = master;
    }

    public Detail(final Master master) {
        this();
        this.master = master;
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
        final Detail other = (Detail) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
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

    public Master getMaster() {
        return master;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    public static List<Detail> listaFake() {
        final List<Detail> lista = new ArrayList<Detail>();

        final List<Master> listaFake = Master.listaFake();
        for (final Master master : listaFake) {
            lista.addAll(master.getDetalhes());
        }
        return lista;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public void setMaster(final Master master) {
        this.master = master;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
