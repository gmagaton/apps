package br.com.dao;

import java.io.File;

import javax.persistence.EntityManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;

public class DBUnitLoader {

    private static DBUnitLoader instance;
    private static SessionImpl session;

    public static DBUnitLoader getInstance(final EntityManager em) {
	session = (SessionImpl) em.getDelegate();
	if (instance == null) {
	    instance = new DBUnitLoader();
	}
	return instance;
    }

    public void carregarXml(final String xmlPath) throws Exception {
	final File xmlFile = new File("src/test/resources" + xmlPath);
	final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
	final FlatXmlDataSet dataSet = builder.build(xmlFile);

	final IDatabaseConnection connection = new DatabaseConnection(session.connection());
	DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    public void limpar(final String xmlPath) throws Exception {
	final File xmlFile = new File("src/test/resources" + xmlPath);
	final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
	final FlatXmlDataSet dataSet = builder.build(xmlFile);

	final IDatabaseConnection connection = new DatabaseConnection(session.connection());
	DatabaseOperation.CLOSE_CONNECTION(DatabaseOperation.DELETE_ALL).execute(connection, dataSet);
    }

}
