package com.projeto.beerbida.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.projeto.beerbida.controller.CervejasController;

//ensinar o spring a encontrar nossos controles

@Configuration
@ComponentScan(basePackageClasses = { CervejasController.class})//onde encontrar os controllers
@EnableWebMvc //diz que meu porjeto é web MVC
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	
	/*
	 * application context é um objeto do spring, quando a aplicação acaba de subir
	 * nós podemos receber esse objeto implementando a interface ApplicationContextAware()
	 * para ser notificado
	 */
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg) throws BeansException {
		this.applicationContext = arg;
		
	}
	
	@Bean
	//vai conseguir encontrar nossas páginas html
	public ViewResolver viewResolver(){
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	@Bean
	//engine vai processar os arquivos html
	public TemplateEngine templateEngine(){
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;
	}
	
	//informar onde está o arquivo html
	private ITemplateResolver templateResolver(){
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();//vai 
		resolver.setApplicationContext(applicationContext);//thymeleaf precisa do application
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}


}
