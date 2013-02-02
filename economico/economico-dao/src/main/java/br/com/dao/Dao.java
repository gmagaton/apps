package br.com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author magaton
 *
 * @param <E>
 * @param <ID>
 */
public interface Dao<E, ID extends Serializable> {

	public void salvar(final E entidade);

	public void atualizar(final E entidade);

	public void remover(final E entidade);

	public E buscarPorId(final ID chave);

	public List<E> buscarTodos();

}
