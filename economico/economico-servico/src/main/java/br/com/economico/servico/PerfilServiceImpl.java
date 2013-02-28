package br.com.economico.servico;

import java.util.List;

import javax.inject.Inject;

import br.com.economico.dao.PerfilDao;
import br.com.economico.modelo.Perfil;

public class PerfilServiceImpl implements PerfilService {

    @Inject
    private PerfilDao dao;

    @Override
    public void delete(final Perfil perfil) {
	dao.remover(perfil);
    }

    @Override
    public List<Perfil> listAll() {
	return dao.buscarTodos();
    }

    @Override
    public void save(final Perfil perfil) {
	dao.salvar(perfil);
    }

}
