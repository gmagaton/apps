package br.com.economico.dao;

import java.util.Calendar;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.dao.DBUnitLoader;
import br.com.economico.modelo.Lancamento;

public class LancamentoDaoTest {

    private final LancamentoDao dao = new LancamentoDao();
    private final String xmlPath = "/dbunit/lancamento-dbunit.xml";

    @AfterMethod
    public void finish() throws Exception {
	dao.beginTransaction();

	final DBUnitLoader loader = DBUnitLoader.getInstance(dao.getEntityManager());
	loader.limpar(xmlPath);

	dao.commitAndCloseTransaction();
    }

    @BeforeMethod
    public void start() throws Exception {
	dao.beginTransaction();

	final DBUnitLoader loader = DBUnitLoader.getInstance(dao.getEntityManager());
	loader.carregarXml(xmlPath);

	dao.commitAndCloseTransaction();
    }

    @Test
    public void testBuscarPorData() {
	dao.beginTransaction();

	final Calendar data = Calendar.getInstance();
	data.clear();
	data.set(Calendar.YEAR, 2013);
	data.set(Calendar.MONTH, 0);
	data.set(Calendar.DAY_OF_MONTH, 15);

	final List<Lancamento> lancamentosPorData = dao.buscarPorData(data);
	Assert.assertNotNull(lancamentosPorData);
	Assert.assertEquals(lancamentosPorData.size(), 3);

	dao.commitAndCloseTransaction();
    }

    @Test
    public void testBuscarPorIntervaloData() {
	dao.beginTransaction();

	final Calendar de = Calendar.getInstance();
	de.clear();
	de.set(Calendar.YEAR, 2013);
	de.set(Calendar.MONTH, 0);
	de.set(Calendar.DAY_OF_MONTH, 1);

	final Calendar ate = Calendar.getInstance();
	ate.clear();
	ate.set(Calendar.YEAR, 2013);
	ate.set(Calendar.MONTH, 0);
	ate.set(Calendar.DAY_OF_MONTH, 5);

	final List<Lancamento> lancamentosPorIntervaloData = dao.buscarPorIntervaloData(ate, ate);
	Assert.assertNotNull(lancamentosPorIntervaloData);
	Assert.assertEquals(lancamentosPorIntervaloData.size(), 5);

	dao.commitAndCloseTransaction();
    }

    @Test
    public void testBuscarTodos() {
	dao.beginTransaction();

	final List<Lancamento> todos = dao.buscarTodos();
	Assert.assertNotNull(todos);
	Assert.assertEquals(todos.size(), 32);

	dao.commitAndCloseTransaction();
    }
}
