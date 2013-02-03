package br.com.economico.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.dao.modelo.Entidade;

public class Lancamento extends Entidade {

    private static final long serialVersionUID = 1L;

    private final Integer id;
    private Conta lancamentoTipo;
    private Calendar data;
    private BigDecimal valor;

    Lancamento() {
	super();
	id = null;
    }

    public Lancamento(Conta lancamentoTipo) {
	this();
	this.setLancamentoTipo(lancamentoTipo);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Lancamento other = (Lancamento) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public Calendar getData() {
	return data;
    }

    public Conta getLancamentoTipo() {
	return lancamentoTipo;
    }

    public BigDecimal getValor() {
	return valor;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    public void setData(Calendar data) {
	this.data = data;
    }

    public void setLancamentoTipo(Conta lancamentoTipo) {
	this.lancamentoTipo = lancamentoTipo;
    }

    public void setValor(BigDecimal valor) {
	this.valor = valor;
    }

}
