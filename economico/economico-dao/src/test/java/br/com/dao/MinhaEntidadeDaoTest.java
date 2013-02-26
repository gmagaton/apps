package br.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.dao.modelo.MinhaEntidade;
import br.com.dao.modelo.MinhaEntidadeDao;
import br.com.dao.modelo.MinhaEntidade_;

public class MinhaEntidadeDaoTest {

    private final MinhaEntidadeDao dao = new MinhaEntidadeDao();
    private final String xmlPath = "/dbunit/minha-entidade-dbunit.xml";

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
    public void testAtualizar() {
	dao.beginTransaction();

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

	dao.commitAndCloseTransaction();
    }

    @Test
    public void testBuscarComFiltro() {
	dao.beginTransaction();

	final Map<SingularAttribute<MinhaEntidade, ?>, Object> filtro = new HashMap<SingularAttribute<MinhaEntidade, ?>, Object>();
	filtro.put(MinhaEntidade_.descricao, "ENTIDADE 3");
	filtro.put(MinhaEntidade_.ativo, false);
	final List<MinhaEntidade> resultado = dao.buscarComFiltro(filtro);

	Assert.assertNotNull(resultado);
	Assert.assertEquals(resultado.size(), 1);

	dao.commitAndCloseTransaction();
    }

    @Test
    public void testSalvar() {
	dao.beginTransaction();

	final MinhaEntidade entidade = new MinhaEntidade("MINHA ENTIDADE", true);
	dao.salvar(entidade);
	Assert.assertNotNull(entidade.getId());

	dao.commitAndCloseTransaction();
    }
}
