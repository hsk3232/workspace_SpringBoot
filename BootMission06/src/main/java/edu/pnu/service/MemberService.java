package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memRepo;
	
	public List<Member> getAllMembers() {
		List<Member> list = memRepo.findAll();
		return list;
		
	}
		
	public Member getMemberById(Integer id) {
		Member m = memRepo.findById(id).get();
		return m;
	}
	
	public Member postMember(Member newData) {
		Member m = new Member();
		m.setName(newData.getName());
		m.setPass(newData.getPass());
		m.setRegidate(new Date());
		memRepo.save(m);
		return m;
	}
	
	public Member putMemberById(@PathVariable Member editData) {
		Member m = memRepo.findById(editData.getId()).get();
		m.setName(editData.getName());
		m.setPass(editData.getPass());
		memRepo.save(m);
		return m;
	}
	
	public Member delMemberInfo(Integer id) {
		Member m = memRepo.findById(id).get();
		memRepo.deleteById(id);
		
		return m;
	}
}
