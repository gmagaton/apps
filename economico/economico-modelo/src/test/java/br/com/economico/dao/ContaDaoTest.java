package br.com.economico.dao;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ContaDaoTest {

    ContaDao dao = new ContaDao();

    @AfterTest
    public void finalizar() {
	dao.commitAndCloseTransaction();
    }

    @BeforeTest
    public void iniciar() {
	dao.beginTransaction();
    }

    public void testBuscarPorTipo() {

    }

}
