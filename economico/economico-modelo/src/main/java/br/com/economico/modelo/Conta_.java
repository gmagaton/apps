package br.com.economico.modelo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = Conta.class)
public class Conta_ {

    public static volatile SingularAttribute<Conta, Integer> id;
    public static volatile SingularAttribute<Conta, String> descricao;
    public static volatile SingularAttribute<Conta, ContaTipo> tipo;
    public static volatile SingularAttribute<Conta, Perfil> perfil;

}
