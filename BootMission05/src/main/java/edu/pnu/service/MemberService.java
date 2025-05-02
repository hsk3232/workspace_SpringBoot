package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
//	4. Lombook을 활용해 사용
	@Autowired
	private final MemberDAO dao;
	@Autowired
	private final LogDao logDao;
	
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
