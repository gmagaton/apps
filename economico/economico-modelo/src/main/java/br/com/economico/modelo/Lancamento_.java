package br.com.economico.modelo;

import java.util.Calendar;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = Lancamento.class)
public class Lancamento_ {

    public static volatile SingularAttribute<Lancamento, Integer> id;
    public static volatile SingularAttribute<Lancamento, Conta> conta;
    public static volatile SingularAttribute<Lancamento, Calendar> data;
    public static volatile SingularAttribute<Lancamento, Double> valor;

}
