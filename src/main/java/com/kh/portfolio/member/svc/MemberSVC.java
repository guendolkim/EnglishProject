package com.kh.portfolio.member.svc;

import com.kh.portfolio.member.vo.MemberVO;

public interface MemberSVC {
	
	/**
	 * 회원등록
	 * @param memberVO
	 * @return
	 */
	int joinMember(MemberVO memberVO);

	/**
	 * 로그인
	 * @param Member_Email
	 * @param Member_Pw
	 * @return
	 */
	boolean login(String MEMBER_EMAIL, String MEMBER_PW);
	
	
	/**
	 * 조회
	 * @param MEMBER_EMAIL
	 * @return
	 */
	MemberVO memberEmail(String MEMBER_EMAIL);
	
	boolean existMember(String MEMBER_EMAIL);
}
