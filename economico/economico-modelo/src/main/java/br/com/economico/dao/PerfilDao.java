package br.com.economico.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import br.com.dao.JPADaoImp;
import br.com.economico.modelo.Perfil;
import br.com.economico.modelo.Perfil_;

public class PerfilDao extends JPADaoImp<Perfil, Integer> {

    public PerfilDao() {
	super(Perfil.class);
    }

    public Perfil buscarPorNome(final String nome) {
	final Map<SingularAttribute<Perfil, ?>, Object> filtro = new HashMap<SingularAttribute<Perfil, ?>, Object>();
	filtro.put(Perfil_.nome, nome);
	final List<Perfil> perfilPorNome = buscarComFiltro(filtro);
	if (perfilPorNome != null && perfilPorNome.size() > 0) {
	    return perfilPorNome.get(0);
	}

	return null;
    }

    public Perfil buscarPorNomeESenha(final String nome, final String senha) {
	final Map<SingularAttribute<Perfil, ?>, Object> filtro = new HashMap<SingularAttribute<Perfil, ?>, Object>();
	filtro.put(Perfil_.nome, nome);
	filtro.put(Perfil_.senha, senha);
	final List<Perfil> perfilPorNome = buscarComFiltro(filtro);
	if (perfilPorNome != null && perfilPorNome.size() > 0) {
	    return perfilPorNome.get(0);
	}

	return null;
    }

}
