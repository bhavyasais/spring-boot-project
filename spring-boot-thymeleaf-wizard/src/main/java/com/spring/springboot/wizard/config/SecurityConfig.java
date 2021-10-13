package com.spring.springboot.wizard.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/wizards/showForm*").hasAnyRole("WIZARD", "DEMENTOR")
			.antMatchers("/wizards/save*").hasAnyRole("WIZARD", "DEMENTOR")
			.antMatchers("/wizards/delete").hasRole("WIZARD")
			.antMatchers("/wizards/**").hasRole("WIZARD")
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}






