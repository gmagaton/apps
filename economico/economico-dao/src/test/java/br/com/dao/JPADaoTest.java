package br.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.SingularAttribute;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.dao.modelo.MinhaEntidade;
import br.com.dao.modelo.MinhaEntidadeDao;
import br.com.dao.modelo.MinhaEntidade_;

public class JPADaoTest {

    private MinhaEntidadeDao dao;

    private static EntityManagerFactory mEmf;
    /** The entity manager that persists and queries the DB. */
    private static EntityManager mEntityManager;

    /**
     * Cleans up the session.
     */
    @AfterClass
    public void closeTestFixture() {
	mEntityManager.getTransaction().commit();
	mEntityManager.close();
	mEmf.close();
    }

    @BeforeClass
    public void initTestFixture() throws Exception {
	// Get the entity manager for the tests.
	mEmf = Persistence.createEntityManagerFactory("PUDaoTest");
	mEntityManager = mEmf.createEntityManager();
	mEntityManager.getTransaction().begin();
	dao = new MinhaEntidadeDao();
	dao.setEntityManager(mEntityManager);
    }

    @Test
    public void testAtualizar() {
	final MinhaEntidade entidade = new MinhaEntidade("MINHA ENTIDADE", true);
	dao.salvar(entidade);
	Assert.assertNotNull(entidade.getId());
    }

    @Test
    public void testBuscarComFiltro() {
	final MinhaEntidade entidade1 = new MinhaEntidade("FILTRO", false);
	dao.salvar(entidade1);

	final MinhaEntidade entidade2 = new MinhaEntidade("FILTRO", true);
	dao.salvar(entidade2);

	final Map<SingularAttribute<MinhaEntidade, ?>, Object> filtro = new HashMap<SingularAttribute<MinhaEntidade, ?>, Object>();
	filtro.put(MinhaEntidade_.descricao, "FILTRO");
	filtro.put(MinhaEntidade_.ativo, true);
	final List<MinhaEntidade> resultado = dao.buscarComFiltro(filtro);

	Assert.assertNotNull(resultado);
	Assert.assertEquals(resultado.size(), 1);
    }

    @Test
    public void testSalvar() {
	// salvar a entidade
	final MinhaEntidade entidade = new MinhaEntidade("MINHA ENTIDADE", true);
	dao.salvar(entidade);

	// buscar para atualizar
	final MinhaEntidade entidadeBuscada = dao.buscarPorId(entidade.getId());
	entidadeBuscada.setDescricao("NOVA ENTIDADE");
	entidadeBuscada.setAtivo(false);
	dao.atualizar(entidadeBuscada);

	// verificar se foi atualizada
	final MinhaEntidade entidadeAtualizada = dao.buscarPorId(entidade.getId());
	Assert.assertNotNull(entidadeAtualizada);
	Assert.assertEquals(entidadeAtualizada.getDescricao(), "NOVA ENTIDADE");
	Assert.assertFalse(entidadeAtualizada.isAtivo());
    }
}
