package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	// 사용자 정보를 담는 List 생성
	private List<MemberVO> list = new ArrayList<MemberVO>();

	// list 생성을 위한 생성자
	public MemberService() {
		for (int i = 1; i <= 10; i++) {
			list.add(MemberVO.builder().id(i).pass("pass" + i).regidate(new Date()).build());
		}
	}

	public List<MemberVO> getAllMember() {
		return list;
	}

	// 검색 선택 사용자 데이터 get
	public MemberVO getMemberById(int id) {
		// list에 id가 존재하는지 확인 후 확인하면 return
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	public MemberVO postMember(MemberVO m) {
		// 동일 id에 데이터 입력시 오류 발생

		if (getMemberById(m.getId()) != null) {
			System.out.println("동일 아이디가 존재합니다.");
			return null;
		}
		// 데이터 입력 및 생성 일자 입력
		m.setRegidate(new Date());
		list.add(m);
		return m;
	}

	// 수정(Update - update) //아이디 값에 해당되는 사용자 데이터 수정
	public int updateMember(MemberVO memberVO) {
		//입력 데이터 중 id를 값을 가지는 객체 생성
		MemberVO m = getMemberById(memberVO.getId());
		
		//생성된 객체 값이 null인지 검사 후 0 또는 1반환
		if(m==null) {
			System.out.println("동일 아이디가 없습니다.");
			return 0;
		}
		//null이 아니라면 이름과 암호 값을 수정
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}

	// 삭제(Delete - delete)
	public int delMember(Integer id) {
		try {
				list.remove(getMemberById(id));
			
		} catch (Exception e) {
			return 0;
		}

		return 1;
	}
}
