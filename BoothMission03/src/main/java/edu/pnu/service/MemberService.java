package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	public MemberDAO dao;
	
	
	public MemberService() {
		dao = new MemberDAO();
	}

	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	// 검색 선택 사용자 데이터 get
	public MemberVO getMemberById(int id) {
		return dao.getMemberById(id);
	}

	public int postMember(MemberVO m) {
		return dao.postMember(m);
	}

	// 수정(Update - update) //아이디 값에 해당되는 사용자 데이터 수정
	public int updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}

	// 삭제(Delete - delete)
	public int delMember(Integer id) {
		return dao.delMember(id);
	}
}
