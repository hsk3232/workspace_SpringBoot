package edu.pnu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.common.JDBConnect;
import edu.pnu.domain.MemberDTO;

@Repository
public class MemberDAO extends JDBConnect {
	private MemberDTO dto;

	
	public Map<String, Object> getAllmember() {
		List<MemberDTO> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		String query = "SELECT * FROM member";
		map.put("method", "getAllmembers");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO ();
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getDate(4));
				
				list.add(dto);
			}
			map.put("list", list);
			map.put("sucess", true);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("sucess", false);
		}
		return map;
	}
	
	public Map<String, Object> getMemberById(int id) {
		Map<String, Object> map = new HashMap<>();
		dto = new MemberDTO ();
		
		String query = "SELECT * FROM member WHERE id=?";
		map.put("method", "getAllmembers");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			
			dto.setId(rs.getInt("id"));
			dto.setPass(rs.getString("pass"));
			dto.setName(rs.getString(3));
			dto.setRegidate(rs.getDate(4));
			
			map.put("dto", dto);
			map.put("sucess", true);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("sucess", false);
		}
		
		return map;
	}
	
	public Map<String, Object> postMember(MemberDTO m) {
		int result = 0;
		
		Map<String, Object> map = new HashMap<>();
	
		
		String query = "INSERT INTO member (pass, name) value(?, ?)";
		map.put("method", "postMember");
		map.put("sqlString", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m.getPass());
			psmt.setString(2, m.getName());
			result = psmt.executeUpdate();
			map.put("result", result);
			
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return map;
	}
	public Map<String, Object> updateMember(MemberDTO m) {
		int result = 0;
		
		Map<String, Object> map = new HashMap<>();
	
		
		String query = "UPDATE FROM member SET pass=?, name=> WHERE id=?";
		map.put("method", "postMember");
		map.put("sqlString", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m.getPass());
			psmt.setString(2, m.getName());
			result = psmt.executeUpdate();
			map.put("result", result);
			
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return map;
	}
	public Map<String, Object> delMember(MemberDTO m) {
		int result = 0;
		
		Map<String, Object> map = new HashMap<>();
	
		
		String query = "DELETE from member (pass, name) value(?, ?) WHERE id=?";
		map.put("method", "postMember");
		map.put("sqlString", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m.getPass());
			psmt.setString(2, m.getName());
			result = psmt.executeUpdate();
			map.put("result", result);
			
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return map;
	}
}
