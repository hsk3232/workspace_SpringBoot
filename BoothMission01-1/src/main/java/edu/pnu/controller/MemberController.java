package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;


@RestController
public class MemberController {
	//사용자 정보를 담는 List 생성
	private List<MemberVO> list = new ArrayList<>();
	
	//list 생성을 위한 생성자
	public MemberController() {
		for(int i = 1; i <= 10; i++) {
			list.add(MemberVO.builder()
					.id(i).name("name" + i)
					.pass("pass" + i)
					.regidate(new Date()).build());

		}
	}
	
	//검색(Get - select) //사용자 전체 데이터 get
	@GetMapping("/members")
	public List<MemberVO> getAllMember() {
		return list;
	}
	
	//검색 (Read - select) //매개변수로 받은 id의 사용자 데이터 get
	@GetMapping("/member")
	public ResponseEntity<?> getMemberById(int id) {
		//list 안에 id가 존재하는지 확인 후 확인하면 return id값 or null;
		for(MemberVO m : list) {
			if(m.getId() == id) {
				return ResponseEntity.ok(m);
			}
		}
		return null;
	}
	
	//입력 (Post - insert) //데이터 입력
	@PostMapping("/member")
	public MemberVO addMember(MemberVO m) {
		//동일 id에 데이터 입력시 오류 발생
		if(getMemberById(m.getId()) != null) {
			System.out.println(m.getId() + "이(가) 이미 존재합니다.");
			return null;
		}
		//데이터 입력 및 생성 일자 입력
		m.setRegidate(new Date());
		list.add(m);
		return m;
	}
	
	//수정(Put - update) //아이디 값에 해당되는 사용자 데이터 수정
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memebrVO) {
		//입력 데이터 중 id를 값을 가지는 객체 생성
		MemberVO m = getMemberById();
		
		//생성된 객체 값이 null인지 검사 후 0 또는 1반환
		
		//null이 아니라면 이름과 암호 값을 수정
	
	}
	//삭제(Delete - delete)
	@DeleteMapping("/member")
	public MemberVO getDelete() {
		
	}
		//list에 id가 있다면, 삭제 후 1 반환 아닐 경우 0반환
		
	
}
