package com.rubypaper.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean // 컨테이너에 미리 올려 놓기 때문에 내가 설정한 시큐리티 필터가 적용되고 자동 필터는 컨테이너에 올라가지 않음
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security -> security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**")
				.hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/admin/**")
				.hasRole("ADMIN")
				.anyRequest()
				.permitAll());
		
		http.csrf(cf -> cf.disable());

		http.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess", true));
		
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
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

	

//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	public void authenticate (AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication()
////			.withUser("member")
////			.password("{noop}abcd")
////			.roles("MEMBER");
////		
////		auth.inMemoryAuthentication()
////			.withUser("manager")
////			.password("{noop}abcd")
////			.roles("MANAGER");
////		
////		auth.inMemoryAuthentication()
////			.withUser("admin")
////			.password("{noop}abcd")
////			.roles("ADMIN");
//		
//		String query1 = "select id username, concat('{noop}', password) password, true enabled from member where id=?";
//		String query2 = "select id, role from member where id=?";
//		
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery(query1)
//			.authoritiesByUsernameQuery(query2);
//	}
	

}
