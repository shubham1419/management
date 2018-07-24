package com.shubham.projectmanagement.configuration;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { HibernateConfig.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebMvcConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
   /*for exception handling*/
   @Override
   protected void customizeRegistration(ServletRegistration.Dynamic registration) {
       boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); // -> true
       if(!done) throw new RuntimeException();
}
}
