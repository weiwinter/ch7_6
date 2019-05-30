package com.wisely.ch7_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.authorizeRequests() 
		.antMatchers("/","/login","/ws").permitAll()
		.anyRequest().authenticated() 
		.and() 
		.formLogin() 
		.loginPage("/login")
		.defaultSuccessUrl("/chat") 
		.permitAll() 
		.and() 
		.logout() 
		.permitAll();
		 

		/*
		 * http .authorizeRequests() .antMatchers("/", "/home").permitAll()
		 * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
		 * .permitAll() .and() .logout() .permitAll();
		 */
		
	}

	//添加內存用戶
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(ENCODER)
                .withUser("wyf")
                .password(ENCODER.encode("wyf"))
                .roles("USER")
                .and()
                .passwordEncoder(ENCODER)
                .withUser("wisely")
                .password(ENCODER.encode("wisely"))
                .roles("USER");
    }
	
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("wyf") .password("wyf")
	 * .roles("USER") .build(); return new InMemoryUserDetailsManager(user); }
	 */
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("wyf").password("{noop}wyf").roles("USER") .and()
	 * .withUser("wisely").password("{noop}wisely").roles("USER");
	 * 
	 * auth .inMemoryAuthentication()
	 * .withUser("wyf").password("{noop}123456").roles("USER") .and()
	 * .withUser("wisely").password("{noop}123456").roles("USER"); }
	 */

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/static/**");
	}
}
