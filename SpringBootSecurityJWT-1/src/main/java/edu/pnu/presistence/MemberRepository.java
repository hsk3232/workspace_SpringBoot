package edu.pnu.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
}
