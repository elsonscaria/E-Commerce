package com.els.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.FormLoginBeanDefinitionParser;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class UserConfiguration extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("elson")
		.password("123")
		.roles("ADMIN")
		.and()
		.withUser("john")
		.password("456")
		.roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/users/all").hasRole("ADMIN")
		.antMatchers("/users/login").hasAnyRole("ADMIN","USER")
		.antMatchers("/products/add").hasRole("ADMIN")
		.antMatchers("/products/delete/{productsId}").hasRole("ADMIN")
		.antMatchers("/products/update/{productId}").hasRole("ADMIN")
		.antMatchers("/users/register").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	
	
	@Bean
	public PasswordEncoder getPwdEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


}