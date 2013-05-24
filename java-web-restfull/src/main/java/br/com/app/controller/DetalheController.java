package br.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.app.model.Detail;
import br.com.app.service.MasterDetalheService;

@Controller
@RequestMapping(value = "/detalhe")
public class DetalheController {

    @Autowired
    private MasterDetalheService masterDetalheService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView detalhes() {
	final ModelAndView modelAndView = new ModelAndView("lista_detalhe");
	final List<Detail> detalhes = masterDetalheService.buscarDetalhes();
	modelAndView.addObject("detalhes", detalhes);
	return modelAndView;
    }

}
