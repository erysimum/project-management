
package com.jrp.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("myuser").password("pass").roles("USER").and().withUser("amit")
				.password("password321").roles("USER").and().withUser("managerUser").password("pass3").roles("ADMIN");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/projects/new").hasRole("USER")
		.antMatchers("/projects/save").hasRole("USER")
		.antMatchers("/employees/new").hasRole("USER")
		.antMatchers("/employees/save").hasRole("USER")
		.antMatchers("/").authenticated().and()
			.formLogin();*/
		http.authorizeRequests().antMatchers("/employees/**", "/new", "/save").hasRole("USER")       
		.antMatchers("/").authenticated().and()
			.formLogin();
		

	}

}
