package br.com.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.tiles.web.startup.simple.SimpleTilesInitializerServlet;
import org.apache.tiles.web.startup.simple.SimpleTilesListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitilizator implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) {
	servletContext.setInitParameter("defaultHtmlEscape", "true");

	servletContext.addFilter("HttpMethodFilter", org.springframework.web.filter.HiddenHttpMethodFilter.class).addMappingForUrlPatterns(null, false, "/*");

	// Contexto do Spring
	final AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
	mvcContext.register(ViewConfig.class);

	// Servlet do Spring MVC
	final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
	dispatcher.setLoadOnStartup(1);

	// Servlet do Tiles (Template)
	final Dynamic tilesServlet = servletContext.addServlet("tiles", new SimpleTilesInitializerServlet());
	tilesServlet.setLoadOnStartup(2);
	servletContext.addListener(new SimpleTilesListener());

	dispatcher.addMapping("/");
    }

}
