package backendspring.infrasructure;

import backendspring.infrasructure.ex.CustomPointcut;
import backendspring.infrasructure.ex.ExceptionHandlerAspect;
import backendspring.infrasructure.mappr.MapperBeanDefinitionRegistrar;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cfg {

    @Bean
    public CustomPointcut customPointcut(){
        return new CustomPointcut();
    }

    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(customPointcut(), exceptionHandlerAspect());
    }

    @Bean
    public MapperBeanDefinitionRegistrar mapperBeanDefinitionRegistrar(){
        return new MapperBeanDefinitionRegistrar();
    }
}
