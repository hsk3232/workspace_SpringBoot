package edu.pnu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class MemberVO {
	private int id;	
	private String pass;
	private String name;
	private Date regidate;

}
