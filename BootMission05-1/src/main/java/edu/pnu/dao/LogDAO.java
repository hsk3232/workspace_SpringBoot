package edu.pnu.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class LogDAO {
	public void addLog(Map<String, Object> map) {
		String query = "INSERT INTO member (method, sqlstring, sucess) value(?,?,?)";
		
		try {
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
