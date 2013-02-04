package br.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.dao.modelo.MinhaEntidade;
import br.com.dao.modelo.MinhaEntidadeDao;
import br.com.dao.modelo.MinhaEntidade_;
import br.com.dao.test.JPADBUnitTest;

public class MinhaEntidadeDaoTest extends JPADBUnitTest {

    MinhaEntidadeDao dao = new MinhaEntidadeDao();

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
	return "/dbunit/minha-entidade-dbunit.xml";
    }

    @BeforeTest
    public void iniciar() {
	dao.beginTransaction();
    }

    @Test
    public void testAtualizar() {
	// buscar para atualizar
	final MinhaEntidade entidadeBuscada = dao.buscarPorId(1);
	Assert.assertFalse(entidadeBuscada.getDescricao().equals("NOVA ENTIDADE"));

	entidadeBuscada.setDescricao("NOVA ENTIDADE");
	entidadeBuscada.setAtivo(false);
	dao.atualizar(entidadeBuscada);

	// verificar se foi atualizada
	final MinhaEntidade entidadeAtualizada = dao.buscarPorId(1);
	Assert.assertNotNull(entidadeAtualizada);
	Assert.assertEquals(entidadeAtualizada.getDescricao(), "NOVA ENTIDADE");
	Assert.assertFalse(entidadeAtualizada.isAtivo());
    }

    @Test
    public void testBuscarComFiltro() {
	final Map<SingularAttribute<MinhaEntidade, ?>, Object> filtro = new HashMap<SingularAttribute<MinhaEntidade, ?>, Object>();
	filtro.put(MinhaEntidade_.descricao, "ENTIDADE 3");
	filtro.put(MinhaEntidade_.ativo, false);
	final List<MinhaEntidade> resultado = dao.buscarComFiltro(filtro);

	Assert.assertNotNull(resultado);
	Assert.assertEquals(resultado.size(), 1);
    }

    @Test
    public void testSalvar() {
	final MinhaEntidade entidade = new MinhaEntidade("MINHA ENTIDADE", true);
	dao.salvar(entidade);
	Assert.assertNotNull(entidade.getId());
    }
}
