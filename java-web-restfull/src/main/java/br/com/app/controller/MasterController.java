package br.com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.app.model.Detail;
import br.com.app.model.Master;
import br.com.app.service.MasterDetalheService;

@Controller
@RequestMapping(value = "/master")
public class MasterController {

    @Autowired
    private MasterDetalheService masterDetalheService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView masters() {
	final ModelAndView modelAndView = new ModelAndView("lista_master");
	final List<Master> masters = masterDetalheService.buscarMasters();
	modelAndView.addObject("masters", masters);
	return modelAndView;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
	final Master novoMaster = new Master();
	final ModelAndView modelView = new ModelAndView("master");
	modelView.addObject("master", novoMaster);
	modelView.addObject("inserir", true);
	return modelView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String novo(@Valid final Master master) {
	// salvar master
	return "novo_sucesso";
    }

    @RequestMapping(value = "/{masterId}", method = RequestMethod.GET)
    public String buscarPorId(@PathVariable final Integer masterId, final Model model) {
	final Master master = masterDetalheService.buscarMasterPorId(masterId);
	model.addAttribute("master", master);
	return "master";
    }

    @RequestMapping(value = "/{masterId}", method = RequestMethod.PUT)
    public String atualizar(@Valid final Master master, final BindingResult result, final Model model) {
	if (result.hasErrors()) {
	    return "master";
	}
	model.addAttribute("msg", "Master Atualizado com sucesso!");

	// atualizar master
	return "master";
    }

    @RequestMapping(value = "/{masterId}", method = RequestMethod.DELETE)
    public ModelAndView removerPorId(@PathVariable final Integer masterId, final Model model) {
	masterDetalheService.removerMaster(masterId);
	return masters();
    }

    @RequestMapping(value = "/{masterId}/detalhes", method = RequestMethod.GET)
    public ModelAndView listarDetalhesPeloMaster(@PathVariable final Integer masterId) {
	final ModelAndView modelAndView = new ModelAndView("master_detalhes");
	final Master master = masterDetalheService.buscarMasterPorId(masterId);
	modelAndView.addObject("master", master);

	final List<Detail> detalhes = masterDetalheService.buscarDetalhesPorMaster(master);
	modelAndView.addObject("detalhes", detalhes);
	return modelAndView;
    }

    @RequestMapping(value = "/recarregar", method = RequestMethod.GET)
    public ModelAndView recarregar() {
	masterDetalheService.recarregar();
	return masters();
    }

}