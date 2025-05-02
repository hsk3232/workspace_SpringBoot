package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberDTO;

public class MemberService {
	private MemberDAO dao;
	private LogDao logDao;
	
	public MemberService() {
		dao = new MemberDAO();
		logDao = new LogDao();
	}
	
	public List<MemberDTO> getAllMember() {
		
		Map<String, Object> map = dao.getAllMember();
		logDao.addLog(map);
		
		
		return (List<MemberDTO>)map.get("list"); 
	}

	public MemberDTO getMemberById(int id) {
		Map<String, Object> map = dao.getMemberById(id);
		logDao.addLog(map);
		
		return (MemberDTO)map.get("dto");
	}
	
	public int postMember(MemberDTO m) {
		Map<String, Object> map = dao.postMember(m);
		logDao.addLog(map);
		return (int)map.get("result");
	}
	
	public int updateMember(MemberDTO m) {
		Map<String, Object> map = dao.updateMember(m);
		logDao.addLog(map);
		return (int)map.get("result");
	}
	
	public int delMember(int id) {
		Map<String, Object> map = dao.delMember(id);
		logDao.addLog(map);
		return (int)map.get("result");
	}
	
	

}
