package br.com.economico.servico;

import java.util.List;

import javax.inject.Inject;

import br.com.economico.dao.LancamentoDao;
import br.com.economico.modelo.Lancamento;

public class LancamentoServiceImpl implements LancamentoService {

    @Inject
    private LancamentoDao dao;

    @Override
    public void delete(final Lancamento lancamento) {
	dao.remover(lancamento);
    }

    @Override
    public List<Lancamento> listAll() {
	return dao.buscarTodos();
    }

    @Override
    public void save(final Lancamento lancamento) {
	dao.salvar(lancamento);
    }

}
