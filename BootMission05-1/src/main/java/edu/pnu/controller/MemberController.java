package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
    private MemberService service;
	
	
	public List<MemberDTO> getAllmember(){
		return service.getAllmember();
	}
	
	public MemberDTO getMemberById(int id) {
		return service.getMemberById(id);
	}
	
	public int postMember(MemberDTO m) {
		return service.postMember(m);
	}
}
