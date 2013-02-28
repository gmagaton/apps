package br.com.economico.modelo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = Perfil.class)
public class Perfil_ {

    public static volatile SingularAttribute<Perfil, Integer> id;
    public static volatile SingularAttribute<Perfil, String> nome;
    public static volatile SingularAttribute<Perfil, String> senha;

}
