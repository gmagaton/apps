package br.com.dao.modelo;

import br.com.dao.JPADaoImp;

public class MinhaEntidadeDao extends JPADaoImp<MinhaEntidade, Integer> {

    public MinhaEntidadeDao() {
	super(MinhaEntidade.class);
    }

}
