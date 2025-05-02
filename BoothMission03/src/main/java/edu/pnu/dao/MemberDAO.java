package edu.pnu.dao;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.JDBConnect;
import edu.pnu.domain.MemberVO;

public class MemberDAO extends JDBConnect {
	//생성자 생성
	
	//모든 사용자를 가져오는 method
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String query = "SELECT * From member";
		
		try {
			
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getInt("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString(3));
				vo.setRegidate(rs.getDate(4));
				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("Get 중 예외 발생");
			e.printStackTrace();
		}
		
		return list;
	}
	
	public  MemberVO getMemberById(int id) {
		MemberVO vo = new MemberVO();
		String query = "SELECT * From member WHere id=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString(3));
				vo.setRegidate(rs.getDate(4));

			}

		} catch (Exception e) {
			System.out.println("Get 중 예외 발생");
			e.printStackTrace();
			return null;
		}

		return vo;
	
	}
	
	public int postMember(MemberVO m) {
		int result = 0;
		try {
			// insert 쿼리문 작성
			String query = "INSERT INTO member (pass, name) values (?, ?)";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, m.getId());
			psmt.setString(2, m.getPass());
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("입력 중 예외 발생");
		}
		return result;
	}
	
	public int updateMember(MemberVO m) {
		int result = 0;
		try {
			// insert 쿼리문 작성
			String query = "UPDATE member SET pass=?, name=? WHERE id=? ";
			if(getMemberById(m.getId()) != null) {
				psmt = con.prepareStatement(query);
				psmt.setString(1, m.getPass());
				psmt.setString(2, m.getName());
				psmt.setInt(3, m.getId());
				result = psmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("업데이트 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int delMember(int id) {
		int result = 0;
		try {
			String query = "DELETE FROM member WHERE id=? ";
			if(getMemberById(id) != null) {
				psmt = con.prepareStatement(query);
				psmt.setInt(1, id);
				result = psmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
}
