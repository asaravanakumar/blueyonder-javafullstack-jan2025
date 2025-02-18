package com.examples.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // extends WebSecurityConfigurerAdapter {

//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			// Disable CSRF check
//			.csrf().disable()
//			// Authorize Requests
//			.authorizeRequests()
//			// Allow root request w/o authentication
//			.antMatchers("/").permitAll()
//			// Allow Registration request w/o authentication
//			.antMatchers("/register/**").permitAll()
//			.antMatchers("/users/**").permitAll()
//			// Allow user endpoint for USER and ADMIN roles
//			.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
//			// Allow manager endpoint for MANAGER and ADMIN roles
//			.antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
//			// Allow admin endpoint for ADMIN role
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			// Authenticate rest all requests
//			.anyRequest().authenticated()
//				.and()
//					// Enables Basic Authentication to access from REST Client
//					.httpBasic()
//				.and()
//					// Enables Form Authentication to access from browser
//					.formLogin();
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		return http.authorizeHttpRequests((requests) -> requests
//						.requestMatchers("/", "/home").permitAll()
//						.anyRequest().authenticated())
//
//				.formLogin((form) -> form
//						.loginPage("/login")
//						.permitAll()
//				)
//				.logout((logout) -> logout.permitAll());
		 	http.csrf(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
					.securityMatcher("/**")
					.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//					.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/", "/users", "/register").permitAll()
						.requestMatchers("/user/**").hasAnyRole("USER", "MANAGER", "ADMIN")
						.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
						.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
						.anyRequest().authenticated())
					.httpBasic(Customizer.withDefaults());
//					.formLogin(Customizer.withDefaults());

			 return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
