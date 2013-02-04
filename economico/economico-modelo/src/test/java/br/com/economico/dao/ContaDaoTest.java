package br.com.economico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.dao.test.JPADBUnitTest;
import br.com.economico.modelo.Conta;
import br.com.economico.modelo.ContaTipo;

public class ContaDaoTest extends JPADBUnitTest {

    ContaDao dao = new ContaDao();

    @AfterTest
    public void finalizar() {
	dao.commitAndCloseTransaction();
    }

    @Override
    protected EntityManager getEntityManager() {
	return dao.getEntityManager();
    }

    @Override
    protected String getXmlPath() {
	return "/dbunit/conta-dbunit.xml";
    }

    @BeforeTest
    public void iniciar() {
	dao.beginTransaction();
    }

    @Test
    public void testBuscarPorTipo() {
	// CREDITO
	final List<Conta> contaTipoCredito = dao.buscarPorTipo(ContaTipo.CREDITO);
	Assert.assertNotNull(contaTipoCredito);
	Assert.assertEquals(2, contaTipoCredito.size());

	// DEBITO
	final List<Conta> contaTipoDebito = dao.buscarPorTipo(ContaTipo.DEBITO);
	Assert.assertNotNull(contaTipoDebito);
	Assert.assertEquals(3, contaTipoDebito.size());
    }

}
