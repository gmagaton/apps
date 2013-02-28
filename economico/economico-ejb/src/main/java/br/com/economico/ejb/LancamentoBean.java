package br.com.economico.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.economico.servico.LancamentoServiceImpl;

@Stateless
@Local(value = LancamentoLocalBusiness.class)
@Remote(value = LancamentoRemoteBusiness.class)
public class LancamentoBean extends LancamentoServiceImpl implements LancamentoLocalBusiness, LancamentoRemoteBusiness {

    @PostConstruct
    public void postContruct() {
	System.out.println("post construct");
    }

    @PreDestroy
    public void preDestroy() {
	System.out.println("pre destroy");
    }
}
