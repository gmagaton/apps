package br.com.economico.ejb;

import javax.ejb.Remote;

import br.com.economico.servico.LancamentoService;

@Remote
public interface LancamentoRemoteBusiness extends LancamentoService {

}
