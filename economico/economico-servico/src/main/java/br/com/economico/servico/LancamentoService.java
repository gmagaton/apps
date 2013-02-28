package br.com.economico.servico;

import java.util.List;

import br.com.economico.modelo.Lancamento;

public interface LancamentoService {

    void delete(Lancamento lancamento);

    List<Lancamento> listAll();

    void save(final Lancamento lancamento);

}
