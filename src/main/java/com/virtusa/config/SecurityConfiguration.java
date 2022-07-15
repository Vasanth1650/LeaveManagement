package com.virtusa.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.virtusa.service.CustomUserService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserService userservice;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
	
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint).and()
		.authorizeRequests(request->request.antMatchers("/api/v1/auth/login","/api/v1/auth/userinfo","/addnew/{id}","/addnew/**","/employee/**").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated())
		.addFilterBefore(new JWTAuthenticationFilter(userservice,jwtTokenHelper),UsernamePasswordAuthenticationFilter.class);
		
		
		http.cors();
		
		http.csrf().disable().headers().frameOptions().disable();
	}

	
	
	

}