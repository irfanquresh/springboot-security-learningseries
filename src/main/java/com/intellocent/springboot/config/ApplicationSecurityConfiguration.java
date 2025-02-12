package com.intellocent.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.intellocent.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @Autowired
	// private DataSource securityDataSource;

	// add a reference to our security data source
	@Autowired
	private UserService userService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("g2").password("123").
		 * roles("ADMIN", "EMPLOYEE"))
		 * .withUser(users.username("bhasker").password("123").roles("MANAGER",
		 * "EMPLOYEE"))
		 * .withUser(users.username("bhavik").password("123").roles("EMPLOYEE"));
		 */

		// MYSQL JDBC based auth
		// auth.jdbcAuthentication().dataSource(securityDataSource);

		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().
		 * loginPage("/showMyLoginPage")
		 * .loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().
		 * permitAll();
		 */

		/*
		 * http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers(
		 * "/leaders/**").hasRole("MANAGER")
		 * .antMatchers("/system/**").hasRole("ADMIN").and().formLogin().loginPage(
		 * "/showMyLoginPage")
		 * .loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().
		 * permitAll().and() .exceptionHandling().accessDeniedPage("/access-denied");
		 */

		
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); // set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); // set the password encoder - bcrypt
		return auth;
	}

}
