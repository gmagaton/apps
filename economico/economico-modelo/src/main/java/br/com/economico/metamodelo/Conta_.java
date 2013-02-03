package br.com.economico.metamodelo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.economico.modelo.Conta;
import br.com.economico.modelo.ContaTipo;

@StaticMetamodel(value = Conta.class)
public class Conta_ {

    public static volatile SingularAttribute<Conta, Integer> id;
    public static volatile SingularAttribute<Conta, String> descricao;
    public static volatile SingularAttribute<Conta, ContaTipo> tipo;

}
