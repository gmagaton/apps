package br.com.economico.dao;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.dao.DBUnitLoader;
import br.com.economico.modelo.Conta;
import br.com.economico.modelo.ContaTipo;

public class ContaDaoTest {

    ContaDao dao = new ContaDao();
    private final String xmlPath = "/dbunit/conta-dbunit.xml";

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
    public void testBuscarPorTipo() {
	dao.beginTransaction();

	// CREDITO
	final List<Conta> contaTipoCredito = dao.buscarPorTipo(ContaTipo.CREDITO);
	Assert.assertNotNull(contaTipoCredito);
	Assert.assertEquals(contaTipoCredito.size(), 2);

	// DEBITO
	final List<Conta> contaTipoDebito = dao.buscarPorTipo(ContaTipo.DEBITO);
	Assert.assertNotNull(contaTipoDebito);
	Assert.assertEquals(contaTipoDebito.size(), 3);

	dao.commitAndCloseTransaction();
    }

}
