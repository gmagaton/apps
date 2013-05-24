package br.com.app.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;

@Configuration
public class TilesConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        final String[] definitions = { "/WEB-INF/tiles.xml" };
        tilesConfigurer.setDefinitions(definitions);
        return tilesConfigurer;
    }

}
