package br.com.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.economico.modelo.Entidade;

public class JPADao<E extends Entidade, ID extends Serializable> implements Dao<E, ID>{

	private EntityManager entityManager;
	private final Class<E> clazz;

	public JPADao(final Class<E> clazz) {
		this.clazz = clazz;
	}

	public void salvar(final E entidade) {
		getEntityManager().persist(entidade);
		getEntityManager().flush();
	}

	public void atualizar(final E entidade) {
		getEntityManager().merge(entidade);
		getEntityManager().flush();
	}

	public void remover(final E entidade) {
		getEntityManager().remove(entidade);
		getEntityManager().flush();
	}

	public E buscarPorId(final ID chave) {
		return getEntityManager().find(getClazz(), chave);
	}

	public List<E> buscarTodos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> criteria = builder.createQuery(getClazz());
		Root<E> entityRoot = criteria.from(getClazz());
		criteria.select(entityRoot);
		TypedQuery<E> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<E> getClazz() {
		return clazz;
	}

}
