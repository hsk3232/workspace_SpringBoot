package com.rubypaper.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.domain.Member;

public class SecurityUser extends User{
	private static final long serialVersionUID = 1L;
	
	// 아아디 암호 외의 정보를 추가적으로 올려 놓을 때 사용하는 클래스
	// 이게 없으면 아이디 암호 이외의 정보를 읽기 위해 다시 db에 접속해서 읽어 와야 함.
	
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(),
		AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
