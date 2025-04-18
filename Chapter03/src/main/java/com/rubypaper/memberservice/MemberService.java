package com.rubypaper.memberservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.dao.MemberDAO;
import com.rubypaper.domain.MemberDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

//	4. Lombook을 활용해 사용
	@Autowired
	private final MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public List<MemberDTO> getAllMember() {
		Map<String, Object> map = dao.getAllMember();
		return (List<MemberDTO>) map.get("list");
	}

	public MemberDTO getMemberById(int id) {
		Map<String, Object> map = dao.getMemberById(id);

		return (MemberDTO) map.get("dto");
	}

	public int postMember() {
		Map<String, Object> map = dao.postMember();
		return (int) map.get("result");
	}

	public int updateMember() {
		Map<String, Object> map = dao.updateMember();
		return (int) map.get("result");
	}

	public int delMember() {
		Map<String, Object> map = dao.delMember();
		return (int) map.get("result");
	}

}
