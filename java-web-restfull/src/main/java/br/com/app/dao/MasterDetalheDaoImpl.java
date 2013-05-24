package br.com.app.dao;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.app.model.Detail;
import br.com.app.model.Master;

@Repository
public class MasterDetalheDaoImpl implements MasterDetalheDao {

    private static final Logger logger = Logger.getLogger(MasterDetalheDaoImpl.class);

    public List<Master> masters = new ArrayList<Master>();

    public MasterDetalheDaoImpl() {
	masters.addAll(Master.listaFake());
    }

    @Override
    public Master buscarMasterPorId(final Integer id) {
	logger.debug("buscando master por id: " + id);
	final Master master = new Master(id, "MASTER");
	final boolean contains = masters.contains(master);
	if (contains) {
	    return masters.get(masters.indexOf(master));
	}
	throw new IllegalStateException("Master nao localzado");
    }

    @Override
    public List<Master> buscarMasters() {
	logger.debug("buscando todos");
	return masters;
    }

    @Override
    public void recarregar() {
	logger.debug("recarregando");
	masters.clear();
	masters.addAll(Master.listaFake());
    }

    @Override
    public void removerMaster(final Integer id) {
	logger.debug("removendo id: " + id);
	final Master master = new Master(id, "");
	final int indexOf = masters.indexOf(master);
	final boolean contains = masters.contains(master);
	if (contains) {
	    masters.remove(indexOf);
	}
    }

    @Override
    public Detail buscarDetalhePorId(final Integer id) {
	for (final Master master : masters) {
	    final List<Detail> detalhes = master.getDetalhes();
	    for (final Detail detalhe : detalhes) {
		if (detalhe.getId().equals(id)) {
		    return detalhe;
		}
	    }
	}
	throw new InvalidParameterException("detalhe id " + id + " nao encontrado");
    }

    @Override
    public List<Detail> buscarDetalhes() {
	final List<Detail> lista = new ArrayList<Detail>();
	for (final Master master : masters) {
	    final List<Detail> detalhes = master.getDetalhes();
	    lista.addAll(detalhes);
	}
	return lista;
    }

    @Override
    public void removerDetalhe(final Integer id) {
	List<Detail> detalhesRemover = null;
	Detail detalheRemover = null;

	master: for (final Master master : masters) {
	    final List<Detail> detalhes = master.getDetalhes();
	    detalhesRemover = detalhes;
	    for (final Detail detalhe : detalhes) {
		if (detalhe.getId().equals(id)) {
		    detalheRemover = detalhe;
		    break master;
		}
	    }
	}

	if (detalhesRemover == null || detalheRemover == null) {
	    throw new InvalidParameterException("detalhe id " + id + " nao encontrado");
	}

	detalhesRemover.remove(detalheRemover);
    }

    @Override
    public List<Detail> buscarDetalhesPorMaster(final Master master) {
	for (final Master masterBanco : masters) {
	    if (masterBanco.equals(master)) {
		return masterBanco.getDetalhes();
	    }
	}
	throw new InvalidParameterException("detalhes do master " + master.getDescricao() + " nao encontrado");
    }

}
