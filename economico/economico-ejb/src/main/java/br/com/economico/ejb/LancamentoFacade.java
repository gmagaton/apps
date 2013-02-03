package br.com.economico.ejb;

import java.util.List;

import br.com.economico.modelo.Lancamento;

public interface LancamentoFacade {

    public List<Lancamento> buscarLancamentosDoDia();

}
