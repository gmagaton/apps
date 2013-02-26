package br.com.economico.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.economico.dao.LancamentoDao;
import br.com.economico.modelo.ContaTipo;
import br.com.economico.modelo.Lancamento;

@Stateless
public class LancamentoFacadeBean implements LancamentoFacadeLocal, LancamentoFacadeRemote {

    @Inject
    private LancamentoDao dao;

    @Override
    public List<Lancamento> buscarLancamentosCreditoDoDia() {
	final Calendar data = Calendar.getInstance();
	return dao.buscarPorContaTipoEData(ContaTipo.CREDITO, data);
    }

    @Override
    public List<Lancamento> buscarLancamentosDebitoDoDia() {
	final Calendar data = Calendar.getInstance();
	return dao.buscarPorContaTipoEData(ContaTipo.DEBITO, data);
    }

    @Override
    public List<Lancamento> buscarLancamentosDoDia() {
	final Calendar data = Calendar.getInstance();
	return dao.buscarPorData(data);
    }
}
