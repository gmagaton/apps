package br.com.economico.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import br.com.dao.JPADaoImp;
import br.com.economico.modelo.Conta;
import br.com.economico.modelo.ContaTipo;
import br.com.economico.modelo.Conta_;

public class ContaDao extends JPADaoImp<Conta, Integer> {

    public ContaDao() {
	super(Conta.class);
    }

    public List<Conta> buscarPorTipo(final ContaTipo tipo) {
	final Map<SingularAttribute<Conta, ?>, Object> filtro = new HashMap<SingularAttribute<Conta, ?>, Object>();
	filtro.put(Conta_.tipo, tipo);
	return buscarComFiltro(filtro);
    }

}
