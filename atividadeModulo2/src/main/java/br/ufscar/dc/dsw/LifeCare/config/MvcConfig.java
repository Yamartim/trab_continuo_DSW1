package br.ufscar.dc.dsw.LifeCare.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
@ComponentScan(basePackages = "br.ufscar.dc.dsw.LifeCare.config")
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/buscar").setViewName("index");
        registry.addViewController("/cadastro").setViewName("cadastro");
        registry.addViewController("/cadastro/profissional").setViewName("cadastroProfissional");
        registry.addViewController("/cadastro/cliente").setViewName("cadastroCliente");
		registry.addViewController("/login").setViewName("login");
        registry.addViewController("/profissional/home").setViewName("Profissional/home");
        registry.addViewController("/cliente/home").setViewName("cliente/home");
        registry.addViewController("/admin/home").setViewName("admin/home");
        registry.addViewController("/perfil").setViewName("perfil");

	}

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("pt","BR"));
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}