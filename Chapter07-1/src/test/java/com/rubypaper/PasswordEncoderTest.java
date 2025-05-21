package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rubypaper.domain.Member;
import com.rubypaper.domain.Role;
import com.rubypaper.persistence.MemberRepository;

@SpringBootTest
public class PasswordEncoderTest {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setId("manager2");
		member.setPassword(encoder.encode("1234"));
		member.setName("매니저");
		member.setRole(Role.ROLE_MANAGER);
		member.setEnabled(true);
		memberRepo.save(member);
		
		Member member2 = new Member();
		member2.setId("manager");
		member2.setPassword(encoder.encode("1234"));
		member2.setName("원조매니저");
		member2.setRole(Role.ROLE_MANAGER);
		member2.setEnabled(true);
		memberRepo.save(member2);
		
		Member member3 = new Member();
		member3.setId("hsk3232");
		member3.setPassword(encoder.encode("1234"));
		member3.setName("창조주");
		member3.setRole(Role.ROLE_ADMIN);
		member3.setEnabled(true);
		memberRepo.save(member3);
		
		Member member4 = new Member();
		member4.setId("user");
		member4.setPassword(encoder.encode("1234"));
		member4.setName("쪼랩이");
		member4.setRole(Role.ROLE_MEMBER);
		member4.setEnabled(true);
		memberRepo.save(member4);
	}
	
}
