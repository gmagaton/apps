package br.com.economico.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import br.com.dao.JPADaoImp;
import br.com.economico.metamodelo.Lancamento_;
import br.com.economico.modelo.Lancamento;

public class LancamentoDao extends JPADaoImp<Lancamento, Integer> {

    public LancamentoDao() {
	super(Lancamento.class);
    }

    public List<Lancamento> buscarPorData(final Calendar data) {
	final Map<SingularAttribute<Lancamento, ?>, Object> filtro = new HashMap<SingularAttribute<Lancamento, ?>, Object>();
	filtro.put(Lancamento_.data, data);
	return buscarComFiltro(filtro);
    }
}
