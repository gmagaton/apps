package br.com.dao.modelo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = MinhaEntidade.class)
public class MinhaEntidade_ {

    public static volatile SingularAttribute<MinhaEntidade, Integer> id;
    public static volatile SingularAttribute<MinhaEntidade, String> descricao;
    public static volatile SingularAttribute<MinhaEntidade, Boolean> ativo;

}
