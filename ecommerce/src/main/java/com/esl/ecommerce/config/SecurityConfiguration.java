package com.esl.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("elson")
		.password(new BCryptPasswordEncoder().encode("123"))
		.authorities("ROLE_ADMIN")
		.and()
		.withUser("john")
		.password(new BCryptPasswordEncoder().encode("456"))
		.authorities("ROLE_USER")
		.and()
		.withUser("jane")
		.password(new BCryptPasswordEncoder().encode("789"))
		.authorities("ROLE_ADMIN")
		.and()
		.withUser("tom")
		.password(new BCryptPasswordEncoder().encode("789"))
		.authorities("ROLE_USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/users/all").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/users/login").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.antMatchers("/products/add").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/products/update/{productId}").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/products/delete/{productsId}").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/users/register").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.and()
		.logout().permitAll();

		http.csrf().disable();
	}
}
	
