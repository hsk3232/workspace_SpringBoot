package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RepositoryTest {
	
	@Autowired
	private MemberRepository memRepo;
	
	@Test
	@Order(1)
	public void dataPreapre() {
		for (int i = 1; i < 10; i++) {
			Member member = new Member();
			member.setName("홍지민");
			member.setPass("지민지민");
			member.setRegidate(new Date());
			memRepo.save(member);
		}
	}
	
	
	@Test
	@Order(2)
	public List<Member> getAllMember(){
		List<Member> list = memRepo.findAll();
		System.out.println(list.toString());
		return list;
	}
	
	
}
