package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;


@RestController //Controller + ResponsBody
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
	
	//검색(Read - select) //사용자 전체 데이터 get
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return list;
	}
	//검색 (Read - select) //매개변수로 받은 id의 사용자 데이터 get
	@GetMapping("/member")
	public MemberVO getMemberById(int id) {
		//list에 id가 존재하는지 확인 후 확인하면 return
		for(MemberVO m : list) {
			if(m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	//입력 (Create - insert) //데이터 입력
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		//동일 id에 데이터 입력시 오류 발생
		if(getMemberById(memberVO.getId()) != null) {
			System.out.println(memberVO.getId() + "이(가) 이미 존재합니다.");
			return null;
		}
		//데이터 입력 및 생성 일자 입력
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	
	//수정(Update - update) //아이디 값에 해당되는 사용자 데이터 수정
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		//입력 데이터 중 id를 값을 가지는 객체 생성
		MemberVO m = getMemberById(memberVO.getId());
		
		//생성된 객체 값이 null인지 검사 후 0 또는 1반환
		if(m==null) {
			return 0;
		}
		//null이 아니라면 이름과 암호 값을 수정
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}
	
	//삭제(Delete - delete)
	@DeleteMapping("/member")
	//(@RequestParam Integer id) <- 생략 된 것
	public int removeMember(Integer id) {
		//list에 id가 있다면, 삭제 후 1 반환 아닐 경우 0반환
		try {
			list.remove(getMemberById(id));
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
}
