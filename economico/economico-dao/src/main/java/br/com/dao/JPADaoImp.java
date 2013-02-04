package br.com.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.internal.SessionImpl;

import br.com.dao.modelo.Entidade;

public class JPADaoImp<E extends Entidade, ID extends Serializable> implements JPADao<E, ID> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUEconomico");
    private EntityManager em;

    private final Class<E> clazz;

    public JPADaoImp(final Class<E> clazz) {
	this.clazz = clazz;
    }

    @Override
    public void atualizar(final E entidade) {
	getEntityManager().merge(entidade);
	getEntityManager().flush();
    }

    public void beginTransaction() {
	em = emf.createEntityManager();
	em.getTransaction().begin();
    }

    @Override
    public List<E> buscarComFiltro(final Map<SingularAttribute<E, ?>, Object> filtro) {
	final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
	final CriteriaQuery<E> criteria = builder.createQuery(clazz);
	final Root<E> root = criteria.from(clazz);
	criteria.select(root);

	final List<Predicate> predicates = createFilters(filtro, builder, root);

	criteria.where(predicates.toArray(new Predicate[predicates.size()]));

	final TypedQuery<E> query = getEntityManager().createQuery(criteria);
	return query.getResultList();
    }

    @Override
    public E buscarPorId(final ID chave) {
	return getEntityManager().find(clazz, chave);
    }

    @Override
    public List<E> buscarTodos() {
	final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
	final CriteriaQuery<E> criteria = builder.createQuery(clazz);
	final Root<E> entityRoot = criteria.from(clazz);
	criteria.select(entityRoot);
	final TypedQuery<E> query = getEntityManager().createQuery(criteria);
	return query.getResultList();
    }

    public void closeTransaction() {
	em.close();
    }

    public void commit() {
	em.getTransaction().commit();
    }

    public void commitAndCloseTransaction() {
	commit();
	closeTransaction();
    }

    private List<Predicate> createFilters(final Map<SingularAttribute<E, ?>, Object> filtro, final CriteriaBuilder builder, final Root<E> root) {
	final List<Predicate> predicates = new ArrayList<Predicate>();

	for (final Entry<SingularAttribute<E, ?>, Object> entry : filtro.entrySet()) {
	    final SingularAttribute<E, ?> atribute = entry.getKey();
	    final Object value = entry.getValue();
	    final Predicate predicate = builder.equal(root.get(atribute), value);
	    predicates.add(predicate);
	}

	return predicates;
    }

    public void flush() {
	em.flush();
    }

    public Connection getConnection() {
	final SessionImpl session = (SessionImpl) getEntityManager().getDelegate();
	return session.connection();
    }

    public EntityManager getEntityManager() {
	return em;
    }

    public void joinTransaction() {
	em = emf.createEntityManager();
	em.joinTransaction();
    }

    @Override
    public void remover(final E entidade) {
	getEntityManager().remove(entidade);
	getEntityManager().flush();
    }

    public void rollback() {
	em.getTransaction().rollback();
    }

    @Override
    public void salvar(final E entidade) {
	getEntityManager().persist(entidade);
	getEntityManager().flush();
    }

}
