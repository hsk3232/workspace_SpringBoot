package com.rubypaper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	// 패스워드 암호화 검증 / 암호화가 안됐을 때는 사용하면 안됨
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(security -> security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**")
				.hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/admin/**")
				.hasRole("ADMIN")
				.anyRequest()
				.permitAll());
		
		http.csrf(cf->cf.disable());
		
		http.formLogin(form->form
				.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess", true));
		
		http.exceptionHandling(ex-> ex.accessDeniedPage("/accessDenied"));
		
		http.logout(logout -> logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login"));
		
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
