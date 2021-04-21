package com.kh.portfolio.member.dao;

import com.kh.portfolio.member.vo.MemberVO;

public interface MemberDAO {

	/**
	 * 회원등록
	 * @param memberVO
	 * @return
	 */
	int joinMember(MemberVO memberVO);
	
	
	/**
	 * 회원삭제
	 * @param Member_Email
	 * @return
	 */
	int deleteMember(String Member_Email, String Member_pw);
	
	/**
	 * 회원아이디찾기
	 * @param Member_tel
	 * @param Member_pw
	 * @return
	 */
	String findMember_Email(String Member_tel, String Member_pw);
	
	/**
	 * 회원비밀번호찾기
	 * @param Member_Email
	 * @param Member_tel
	 * @param Member_birth
	 * @return
	 */
	String findMember_Pw(String Member_Email, String Member_tel, String Member_birth);
	
	/**
	 * 회원수정
	 * @param memberVO
	 * @return
	 */
	int modifyMember(MemberVO memberVO);
	
	/**
	 * 비밀번호수정
	 * @param Member_Email
	 * @param Member_oldPw
	 * @param Member_newPw
	 * @return
	 */
	int changeMember_Pw(String Member_Email, String Member_oldPw, String Member_newPw);
	
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
