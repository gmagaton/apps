package br.com.economico.servico;

import java.util.List;

import br.com.economico.modelo.Perfil;

public interface PerfilService {

    void delete(final Perfil perfil);

    List<Perfil> listAll();

    void save(final Perfil perfil);

}
