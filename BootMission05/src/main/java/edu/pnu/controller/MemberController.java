package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

//  1. 필드에 사용
//	@Autowired
	private MemberService ms;
	
	// 2. 생성자를 활용해 사용
	public MemberController(MemberService ms) {
		this.ms = ms;
		System.out.println("MemberController");
	}
	
	@GetMapping("/members")
	public List<MemberDTO> getAllMember() {
		return ms.getAllMember();
	}
	
	@GetMapping("/member")
	public MemberDTO getMemberById(int id) {
		return ms.getMemberById(id);
	}
	
	@PostMapping("/member")
	public int postMember(MemberDTO m) {
		return ms.postMember(m);
	}
	
	@PutMapping("/member")
	public int updateMember(MemberDTO m) {
		return ms.updateMember(m);
	}
	
	@DeleteMapping("/member")
	public int delMember(int id) {
		return ms.delMember(id);
	}


}
