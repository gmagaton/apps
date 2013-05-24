package br.com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.dao.MasterDetalheDao;
import br.com.app.model.Detail;
import br.com.app.model.Master;

@Service
public class MasterDetalheServiceImpl implements MasterDetalheService {

    private MasterDetalheDao dao;

    public MasterDetalheServiceImpl() {
	super();
    }

    @Autowired
    public MasterDetalheServiceImpl(final MasterDetalheDao dao) {
	this.dao = dao;
    }

    @Override
    public Detail buscarDetalhePorId(final Integer id) {
	return dao.buscarDetalhePorId(id);
    }

    @Override
    public List<Detail> buscarDetalhes() {
	return dao.buscarDetalhes();
    }

    @Override
    public List<Detail> buscarDetalhesPorMaster(final Master master) {
	return dao.buscarDetalhesPorMaster(master);
    }

    @Override
    public void removerDetalhe(final Integer id) {
	dao.removerDetalhe(id);
    }

    @Override
    public Master buscarMasterPorId(final Integer id) {
	return dao.buscarMasterPorId(id);
    }

    @Override
    public List<Master> buscarMasters() {
	return dao.buscarMasters();
    }

    @Override
    public void recarregar() {
	dao.recarregar();
    }

    @Override
    public void removerMaster(final Integer id) {
	dao.removerMaster(id);
    }

}
