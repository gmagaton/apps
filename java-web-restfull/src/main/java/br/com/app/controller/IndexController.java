package br.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
