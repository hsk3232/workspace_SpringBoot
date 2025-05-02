package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	private MemberService service;

	private MemberController() {
		service = new MemberService();
	}

	// 검색 (Read - select) //사용자 전체 데이터 get
	@GetMapping("/members")
	public List<MemberVO> getAllMember() {
		return service.getAllMember();
	}

	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		return service.getMemberById(id);
	}

	// 입력 (Create - insert) //데이터 입력
	@PostMapping("/member")
	public int postMember(MemberVO m) {
		return service.postMember(m);

	}

	// 수정(Update - update)
	// json으로 데이터를 넘길 때 @RequestBoyd 써야 한다.
	@PutMapping("/member")
	public int updateMember(@RequestBody MemberVO m) {
		return service.updateMember(m);
	}

	// 삭제(Delete - delete)
	@DeleteMapping("/member")
	public int delMember(Integer id) {
		return service.delMember(id);
	}

}
