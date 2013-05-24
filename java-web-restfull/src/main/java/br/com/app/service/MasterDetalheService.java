package br.com.app.service;

import java.util.List;

import br.com.app.model.Detail;
import br.com.app.model.Master;

public interface MasterDetalheService {

    Master buscarMasterPorId(final Integer id);

    List<Master> buscarMasters();

    void recarregar();

    void removerMaster(final Integer id);

    Detail buscarDetalhePorId(final Integer id);

    List<Detail> buscarDetalhes();

    List<Detail> buscarDetalhesPorMaster(final Master master);

    void removerDetalhe(final Integer id);

}
