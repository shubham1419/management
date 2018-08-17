package com.shubham.projectmanagement.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
 
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.inMemoryAuthentication().withUser("user")
		 * .password("password").roles("USER");
		 */
		
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email, password, status" + " from employee where email=?")
				.authoritiesByUsernameQuery("select email, role" + " from employee where email=?")
				.passwordEncoder(new BCryptPasswordEncoder());
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				/* for admin */
				.antMatchers("/manage/**").hasAuthority("ADMIN")
				/* for users */
				.antMatchers("/dashboard").hasAuthority("USER")
				/* for all */
				.antMatchers("/**").permitAll()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied")
				.and()
				.httpBasic(); // Authenticate basic authentication
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
