package edu.pnu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.common.JDBConnect;
import edu.pnu.domain.MemberDTO;

public class MemberDAO extends JDBConnect{
	
	//Get(read)
	public Map<String, Object> getAllMember(){
		//db에서 가져온 data를 list 형태로 반환
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		//데이터 return을 map 형태로 함.
		Map<String, Object> map = new HashMap<>();
		
		String query = "SELECT * FROM member";
		map.put("method", "getAllMember");
		map.put("sqlstring", query);
		
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getDate(4));
				
				list.add(dto);
			}
			map.put("success", true);
			map.put("list", list);
			
		}catch (Exception e) {
			System.out.println("read 중 오류 발생");
			System.out.println(e.getMessage());
			map.put("success", false);
		}
		
		
		return map;
	}
	
	public Map<String, Object> getMemberById(int id) {
		MemberDTO dto = new MemberDTO();
		
		Map<String, Object> map = new HashMap<>();
		String query = "SELECT * FROM member where id=?";
		
		map.put("method", "getMemberById");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getDate(4));
				
				
			}
			map.put("dto", dto);
			map.put("success", true);
			
			
		} catch (Exception e) {
			System.out.println("개별 아이디 read 중 오류 발생");
			System.out.println(e.getMessage());
			map.put("success", false);
		}finally {
			close(); // JDBConnect 에 close() 만들어놨다면 호출
		}
		return map;
	}
	
	//Post(create)
	public Map<String, Object> postMember(MemberDTO dto) {
		int result = 0;
		Map<String, Object> map = new HashMap<>();
		String query = "INSERT INTO member (pass, name) value (?,?)";
		
		map.put("method", "postMember");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			result = psmt.executeUpdate();			
			
			map.put("result", result);
			map.put("success", true);
			
			
		}catch (Exception e) {
			System.out.println("insert 중 오류");
			System.out.println(e.getMessage());
			map.put("success", false);
			
		}
		return map;
	}
	
	//put(update)
	public Map<String, Object> updateMember(MemberDTO dto) {
		int result = 0;
		Map<String, Object> map = new HashMap<>();
		String query = "UPDATE member SET pass=?, name=? WHERE id=?";
		
		map.put("method", "updateMember");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getId());
			result = psmt.executeUpdate();
			
			map.put("result", result);
			map.put("success", true);
			
			
		} catch (Exception e) {
			System.out.print("update 중 오류");
			System.out.println(e.getMessage());
			map.put("success", false);
		} 
		return map;
	}
	
	public Map<String, Object> delMember(int id) {
		int result = 0;
		Map<String, Object> map = new HashMap<>();
		String query = "DELETE FROM member WHERE id=?";
		
		map.put("method", "delMember");
		map.put("sqlstring", query);
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			result = psmt.executeUpdate();
			
			map.put("result", result);
			map.put("success", true);
			
				
		} catch(Exception e) {
			System.out.println("delete 중 오류");
			System.out.println(e.getMessage());
			map.put("success", false);
		} 
		return map;
	}
	
}
