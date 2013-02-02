package br.com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

public interface JPADao<E, ID extends Serializable> extends Dao<E, ID> {

    public List<E> buscarComFiltro(final Map<SingularAttribute<E, ?>, Object> filtro);

}
