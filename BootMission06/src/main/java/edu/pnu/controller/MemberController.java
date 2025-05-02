package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
@RequestMapping("/test")
public class MemberController {
	
	@Autowired
	private MemberService service;	
	
	@GetMapping("/members")
	public List<Member> getAllMembers() {
		List<Member> list = service.getAllMembers();
		return list;
	}
	
	@GetMapping("/member/{id}")
	public Member getMemberById(@PathVariable Integer id) {
		Member member = service.getMemberById(id);
		return member;
	}
	
	@PostMapping("/member")
	public Member postMember(Member newData) {
		Member m = service.postMember(newData);
		return m;
	}
	
	@PutMapping("/member")
	public Member putMemberById(Member editData) {
		Member m = service.putMemberById(editData);
		return m;
	}
	@DeleteMapping("/member")
	public Member delMemberInfo(Integer id) {
		Member m = service.delMemberInfo(id);
		return m;
	}
	
}
