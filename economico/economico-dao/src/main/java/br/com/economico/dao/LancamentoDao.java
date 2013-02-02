package br.com.economico.dao;

import java.util.Calendar;
import java.util.List;

import br.com.dao.JPADao;
import br.com.economico.modelo.Lancamento;

public class LancamentoDao extends JPADao<Lancamento, Integer> {

    public LancamentoDao() {
	super(Lancamento.class);
    }

    public List<Lancamento> buscarPorData(final Calendar data) {
	return null;
    }

}
