package com.rubypaper;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.dao.MemberDAO;
import com.rubypaper.domain.MemberDTO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberDaoTest {
	@Autowired
	private MemberDAO memberDao;
	
	@Order(3)
	@Test
	@DisplayName("Member select All 테스트")
	public void selectTest() {
		Map<String, Object> map = memberDao.getAllMember();
		List<MemberDTO> list = (List<MemberDTO>)map.get("list");
		for(MemberDTO m : list) 
			System.out.println(m);
	}
	@Order(1)
	@DisplayName("Member insert 테스트")
	@Test
	public void insertTest() {
		System.out.println("InsertTest");
		
		Map<String, Object> map = memberDao.postMember();
		System.out.println("업테이트 성공");
	}
	
	@Order(2)
	@DisplayName("Member update 테스트")
	@Test
	public void updateTest() {
		System.out.println("UpdateTest");
	}
	
}
