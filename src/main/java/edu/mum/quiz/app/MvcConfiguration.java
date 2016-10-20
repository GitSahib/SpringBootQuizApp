package edu.mum.quiz.app;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import edu.mum.quiz.app.aop.ExecuteTimeInterceptor;
import edu.mum.quiz.app.aop.MaintenanceInterceptor;

@Configuration
@EnableAutoConfiguration
@ComponentScan("edu.mum.quiz")
@EnableJpaRepositories("edu.mum.quiz.repository")
@EntityScan(basePackages = "edu.mum.quiz.domain")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	MessageSource messageSource;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/404.html").setViewName("404");
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/userimages/**")
          .addResourceLocations("file:/users/userimages/");
    }
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource);
		return validator;
	}
	
	@Bean
	public MaintenanceInterceptor maintenanceInterceptor() {
		MaintenanceInterceptor interceptor = new MaintenanceInterceptor();
		interceptor.setMaintenanceStartTime(12);
		interceptor.setMaintenanceEndTime(13);
		interceptor.setMaintenanceMapping("maintenance");
		return interceptor;
	}
	@Bean
	public ExecuteTimeInterceptor executeTimeInterceptor() {
		ExecuteTimeInterceptor interceptor = new ExecuteTimeInterceptor();
		return interceptor;
	}
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("lang");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		registry.addInterceptor(interceptor);
		registry.addInterceptor(executeTimeInterceptor());
		registry.addInterceptor(maintenanceInterceptor());
	}
	

}
