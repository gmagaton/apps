package br.com.economico.ejb;

import java.util.List;

import br.com.economico.modelo.Lancamento;

public interface LancamentoFacade {

    public List<Lancamento> buscarLancamentosCreditoDoDia();

    public List<Lancamento> buscarLancamentosDebitoDoDia();

    public List<Lancamento> buscarLancamentosDoDia();

}
