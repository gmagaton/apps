// package br.com.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//
//import br.com.app.dao.MasterDao;
//import br.com.app.dao.MasterDaoImpl;
//import br.com.app.service.MasterService;
//import br.com.app.service.MasterServiceImpl;
//
//@Configuration
//@ComponentScan(basePackages = { "br.com.app.dao", "br.com.app.service" })
//public class ServiceConfig {
//
//    @Bean
//    @Lazy
//    public MasterDao masterDao() {
//        return new MasterDaoImpl();
//    }
//
//    @Bean
//    public MasterService masterService() {
//        return new MasterServiceImpl(masterDao());
//    }
//
//    //    @Bean
//    //    public MBeanServerConnectionFactoryBean clientConnector() {
//    //        final MBeanServerConnectionFactoryBean clientConnector = new MBeanServerConnectionFactoryBean();
//    //        try {
//    //            clientConnector.setServiceUrl("service:jmx:rmi://localhost:9875");
//    //        } catch (final MalformedURLException e) {
//    //            // TODO Auto-generated catch block
//    //            e.printStackTrace();
//    //        }
//    //        return clientConnector;
//    //    }
//}
