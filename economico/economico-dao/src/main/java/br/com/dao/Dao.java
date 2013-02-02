package br.com.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<E, ID extends Serializable> {

    public void atualizar(final E entidade);

    public E buscarPorId(final ID chave);

    public List<E> buscarTodos();

    public void remover(final E entidade);

    public void salvar(final E entidade);

}
