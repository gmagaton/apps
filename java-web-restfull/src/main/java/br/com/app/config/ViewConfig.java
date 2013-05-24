package br.com.app.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.com.app.controller", "br.com.app.dao", "br.com.app.service" })
public class ViewConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/");
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UrlBasedViewResolver viewResolver() {
	final UrlBasedViewResolver urlBasedViewResolver = new TilesViewResolver();
	return urlBasedViewResolver;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LocalValidatorFactoryBean validator() {
	return new LocalValidatorFactoryBean();
    }

}
