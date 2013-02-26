package br.com.economico.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dao.modelo.Entidade;

@Entity
@Table(name = "LANCAMENTO")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GERADOR_SQ_LANCAMENTO", sequenceName = "SQ_LANCAMENTO")
public class Lancamento extends Entidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_LANCAMENTO")
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA")
    private Conta conta;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA")
    private Calendar data;

    @Column(name = "VALOR")
    private Double valor;

    Lancamento() {
	super();
	setId(null);
    }

    public Lancamento(final Conta conta) {
	this();
	setConta(conta);
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
	final Lancamento other = (Lancamento) obj;
	if (getId() == null) {
	    if (other.getId() != null) {
		return false;
	    }
	} else if (!getId().equals(other.getId())) {
	    return false;
	}
	return true;
    }

    public Conta getConta() {
	return conta;
    }

    public Calendar getData() {
	return data;
    }

    public Integer getId() {
	return id;
    }

    public Double getValor() {
	return valor;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (getId() == null ? 0 : getId().hashCode());
	return result;
    }

    public void setConta(final Conta conta) {
	this.conta = conta;
    }

    public void setData(final Calendar data) {
	this.data = data;
    }

    public void setId(final Integer id) {
	this.id = id;
    }

    public void setValor(final Double valor) {
	this.valor = valor;
    }

    @Override
    public String toString() {
	final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	return "Lancamento [id=" + id + ", conta=" + conta + ", data=" + format.format(data.getTime()) + ", valor=" + valor + "]";
    }

}
