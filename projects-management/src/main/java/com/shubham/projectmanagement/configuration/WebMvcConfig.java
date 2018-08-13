package com.shubham.projectmanagement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.shubham.projectmanagement"})
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private WebFlow webFlowConfig;

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }

   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }

   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }
   
   @Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/assets/");
	}	
   
   @Bean
   public MultipartResolver multipartResolver() {
      StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
      return resolver;
   }
   /*web flow**/
   
   @Bean
   public FlowHandlerMapping flowHandlerMapping() {
       FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
       handlerMapping.setOrder(-1);
       handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
       return handlerMapping;
   }

   @Bean
   public FlowHandlerAdapter flowHandlerAdapter() {
       FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
       handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
       handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
       return handlerAdapter;
}
   
   /***/
}

