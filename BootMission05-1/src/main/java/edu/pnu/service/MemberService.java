package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDAO;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	@Autowired
	private LogDAO logdao;
	
	public List<MemberDTO> getAllmember(){
		Map<String, Object> map = dao.getAllmember();
		logdao.addLog(map);
		return (List<MemberDTO>)map.get("list");
	}
	
	public MemberDTO getMemberById(int id) {
		Map<String, Object> map = dao.getMemberById(id);
		logdao.addLog(map);	
		return (MemberDTO)map.get("dto");
	}
	
	public int postMember(MemberDTO m) {
		Map<String, Object> map = dao.postMember(m);
		logdao.addLog(map);
		return (int) map.get("result");
	}
}
