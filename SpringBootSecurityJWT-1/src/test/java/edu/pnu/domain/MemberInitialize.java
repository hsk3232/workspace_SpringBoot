package edu.pnu.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.presistence.MemberRepository;

@SpringBootTest
public class MemberInitialize {
	@Autowired
	MemberRepository memRepo;
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	@Test
	public void testInsert() {
		memRepo.save(Member.builder()
				.username("member2")
				.password(encoder.encode("1"))
				.role(Role.ROLE_MEMBER)
				.enabled(true).build());
		memRepo.save(Member.builder()
				.username("manager2")
				.password(encoder.encode("1"))
				.role(Role.ROLE_MANAGER)
				.enabled(true).build());
		memRepo.save(Member.builder()
				.username("admin2")
				.password(encoder.encode("1"))
				.role(Role.ROLE_ADMIN)
				.enabled(true).build() );
	}
}
     