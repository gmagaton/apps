package br.com.economico.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.economico.dao.LancamentoDao;
import br.com.economico.modelo.Lancamento;

@Stateless
public class LancamentoFacadeBean implements LancamentoFacadeLocal, LancamentoFacadeRemote {

    @Inject
    private LancamentoDao dao;

    @Override
    public List<Lancamento> buscarLancamentosDoDia() {
	final Calendar data = Calendar.getInstance();
	data.clear(Calendar.HOUR_OF_DAY);
	data.clear(Calendar.MINUTE);
	data.clear(Calendar.SECOND);
	data.clear(Calendar.MILLISECOND);
	return dao.buscarPorData(data);
    }
}
