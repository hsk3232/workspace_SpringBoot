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
		member.setId("member");
		member.setPassword(encoder.encode("abcd"));
		member.setName("홍지민");
		member.setRole(Role.ROLE_MEMBER);
		member.setEnabled(true);
		memberRepo.save(member);
		
		Member manager = new Member();
		manager.setId("manager");
		manager.setPassword(encoder.encode("abcd"));
		manager.setName("매니저2");
		manager.setRole(Role.ROLE_MANAGER);
		manager.setEnabled(true);
		memberRepo.save(manager);
		
		Member member3 = new Member();
		member3.setId("admin");
		member3.setPassword(encoder.encode("abcd"));
		member3.setName("관리자");
		member3.setRole(Role.ROLE_ADMIN);
		member3.setEnabled(true);
		memberRepo.save(member3);
	}

}
