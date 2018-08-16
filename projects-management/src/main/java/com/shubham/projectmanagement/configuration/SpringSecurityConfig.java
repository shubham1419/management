package com.shubham.projectmanagement.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.inMemoryAuthentication()
	         .withUser("shubh@gmail.com").password("pass123").roles("USER")
	         .and()
	         .withUser("admin@gmail.com").password("pass123").roles("ADMIN");
	   }

	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http
	      /*.authorizeRequests().antMatchers("/").permitAll()
	      .and()*/
	      .authorizeRequests().antMatchers("/**").hasRole("USER")
	      /*.and()
	      .authorizeRequests().antMatchers("/manage**").hasRole("ADMIN")*/
	      .and()
	      .formLogin();
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	 auth.inMemoryAuthentication().withUser("sg@gmail.com").password("123456").roles("USER");
	
  auth.jdbcAuthentication().dataSource(dataSource)
      .usersByUsernameQuery("select email, password, status"
          + " from employee where email=?")
      .authoritiesByUsernameQuery("select email,role"
          + "from employee where email=?")
      .passwordEncoder(new BCryptPasswordEncoder());
} 

@Override
protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests()
	/*for admin*
	.antMatchers("/manage/**").hasAuthority("ADMIN")
	/*for users*
	.antMatchers("/register/**").hasAuthority("USER")
	/*for all*
	.antMatchers("/**").permitAll()
	.and().formLogin().loginPage("/login").permitAll()
	.and()
    .exceptionHandling().accessDeniedPage("/access-denied")
    .and()
    .httpBasic(); // Authenticate users with HTTP basic authentication
}	
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }
    */
    
}
