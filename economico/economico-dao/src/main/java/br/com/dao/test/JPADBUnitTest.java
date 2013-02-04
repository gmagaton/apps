package br.com.dao.test;

import java.io.File;

import javax.persistence.EntityManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;
import org.testng.annotations.BeforeMethod;

public abstract class JPADBUnitTest {

    @BeforeMethod
    public void carregarXml() throws Exception {
	final File xmlFile = new File("src/test/resources" + getXmlPath());
	final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
	final FlatXmlDataSet dataSet = builder.build(xmlFile);

	final SessionImpl session = (SessionImpl) getEntityManager().getDelegate();

	final IDatabaseConnection connection = new DatabaseConnection(session.connection());
	DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    protected abstract EntityManager getEntityManager();

    protected abstract String getXmlPath();

}
