package br.com.economico.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.dao.test.JPADBUnitTest;
import br.com.economico.modelo.Lancamento;

public class LancamentoDaoTest extends JPADBUnitTest {

    private final LancamentoDao dao = new LancamentoDao();

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
	return "/dbunit/lancamento-dbunit.xml";
    }

    @BeforeTest
    public void iniciar() {
	dao.beginTransaction();
    }

    @Test
    public void testBuscarPorData() {
	final Calendar data = Calendar.getInstance();
	data.set(Calendar.YEAR, 2013);
	data.set(Calendar.MONTH, 0);
	data.set(Calendar.DAY_OF_MONTH, 15);

	final List<Lancamento> lancamentosPorData = dao.buscarPorData(data);
	Assert.assertNotNull(lancamentosPorData);
	Assert.assertEquals(lancamentosPorData.size(), 3);
    }

    @Test
    public void testBuscarPorIntervaloData() {
	final Calendar de = Calendar.getInstance();
	de.set(Calendar.YEAR, 2013);
	de.set(Calendar.MONTH, 0);
	de.set(Calendar.DAY_OF_MONTH, 1);

	final Calendar ate = Calendar.getInstance();
	ate.set(Calendar.YEAR, 2013);
	ate.set(Calendar.MONTH, 0);
	ate.set(Calendar.DAY_OF_MONTH, 15);

	final List<Lancamento> lancamentosPorIntervaloData = dao.buscarPorIntervaloData(ate, ate);
	Assert.assertNotNull(lancamentosPorIntervaloData);
	Assert.assertEquals(lancamentosPorIntervaloData.size(), 17);
    }
}
