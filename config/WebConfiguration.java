/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 *
 * @author Dennys
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pe.edu.cibertec.eva2")
public class WebConfiguration implements WebMvcConfigurer{
    
//    Si trabajo con JSP
//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("WEB-INF/vistas/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    
//    }
    
    //Si quiero trabajar con Thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateRosolver(){
    
        SpringResourceTemplateResolver resolver  = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix("html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }
    
    
    @Bean 
    public SpringTemplateEngine templateEngine(){
    
        SpringTemplateEngine engine =  new SpringTemplateEngine();
        engine.setTemplateResolver(templateRosolver());
        engine.setEnableSpringELCompiler(true);
        return engine;
        
    } 
    
    @Bean
    public ViewResolver viewResolver(){
    
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    
    }
    
    
}
