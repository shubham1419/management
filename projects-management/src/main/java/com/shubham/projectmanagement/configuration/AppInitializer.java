package com.shubham.projectmanagement.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { HibernateConfig.class, SpringSecurityConfig.class };
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
       
       /*for file upload*/
    // upload temp file will put here
       File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

       // register a MultipartConfigElement
       MultipartConfigElement multipartConfigElement =
               new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                       maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

       registration.setMultipartConfig(multipartConfigElement);
}
   
 
}
