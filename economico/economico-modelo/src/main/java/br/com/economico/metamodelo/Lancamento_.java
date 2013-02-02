package br.com.economico.metamodelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.economico.modelo.Conta;
import br.com.economico.modelo.Lancamento;

@StaticMetamodel(value = Lancamento.class)
public class Lancamento_ {

    public static volatile SingularAttribute<Lancamento, Integer> id;
    public static volatile SingularAttribute<Lancamento, Conta> lancamentoTipo;
    public static volatile SingularAttribute<Lancamento, Calendar> data;
    public static volatile SingularAttribute<Lancamento, BigDecimal> valor;

}
