package br.com.economico.dao;

import java.util.List;

import br.com.dao.JPADao;
import br.com.economico.modelo.Conta;
import br.com.economico.modelo.ContaTipo;

public class ContaDao extends JPADao<Conta, Integer> {

	public ContaDao() {
		super(Conta.class);
	}

	public List<Conta> buscarPorTipo(final ContaTipo tipo) {
		return null;
	}

}
