package edu.pnu.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.util.CustomMyUtil;
import edu.pnu.util.JWTUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	@Autowired private MemberRepository memRepo;
	@Lazy
	@Autowired private PasswordEncoder encoder;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException{
		
		log.info("OAuth2SuccessHandler:onAuthenticationSuccess");
		OAuth2User user = (OAuth2User)authentication.getPrincipal();
		
		String username = CustomMyUtil.getUsernameFromOAuth2User(user);
		if (username == null) {
			log.error("onAuthenticationSuccess:Cannot generate Username from oauth2user!");
			throw new ServletException("Cannot generate username from oauth2user!");
		}
		log.info("onAuthenticationSuccess:" + username);
		memRepo.save(Member.builder()
				.username(username)
				.password(encoder.encode("*"))
				.role(Role.ROLE_MEMBER)
				.enabled(true).build());
		
		String jwtToken = JWTUtil.getJWT(username);
		response.setHeader("Authorization", jwtToken);
	}
}






