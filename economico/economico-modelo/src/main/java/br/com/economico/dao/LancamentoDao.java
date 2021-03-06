package br.com.economico.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import br.com.dao.JPADaoImp;
import br.com.economico.modelo.ContaTipo;
import br.com.economico.modelo.Lancamento;
import br.com.economico.modelo.Lancamento_;

public class LancamentoDao extends JPADaoImp<Lancamento, Integer> {

    public LancamentoDao() {
	super(Lancamento.class);
    }

    public List<Lancamento> buscarPorContaTipoEData(final ContaTipo tipo, final Calendar data) {
	return null;
    }

    public List<Lancamento> buscarPorData(final Calendar data) {
	final Map<SingularAttribute<Lancamento, ?>, Object> filtro = new HashMap<SingularAttribute<Lancamento, ?>, Object>();
	filtro.put(Lancamento_.data, data);
	return buscarComFiltro(filtro);
    }

    public List<Lancamento> buscarPorIntervaloData(final Calendar de, final Calendar ate) {
	final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
	final CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
	final Root<Lancamento> root = criteria.from(Lancamento.class);
	final CriteriaQuery<Lancamento> select = criteria.select(root);
	select.where(builder.greaterThanOrEqualTo(root.get(Lancamento_.data), de));
	select.where(builder.lessThanOrEqualTo(root.get(Lancamento_.data), ate));
	return getEntityManager().createQuery(criteria).getResultList();

    }
}
