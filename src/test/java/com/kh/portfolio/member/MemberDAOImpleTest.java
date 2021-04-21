package com.kh.portfolio.member;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.code.dao.CodeDAO;
import com.kh.portfolio.code.svc.CodeSVC;
import com.kh.portfolio.code.vo.CodeVO;
import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOImpleTest {

	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	JdbcTemplate jt;
	
	@Test
	@DisplayName("회원가입")
	@Disabled
	void joinMember() {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMEMBER_EMAIL("test4@test.com");
		memberVO.setMEMBER_PW("1234");
		memberVO.setMEMBER_NICKNAME("테스터4");
		memberVO.setMEMBER_TEL("010-1111-3333");
		memberVO.setMEMBER_GENDER("여");
		memberVO.setMEMBER_BIRTH(LocalDate.of(2020, 04, 14));
		
		int result = memberDAO.joinMember(memberVO);
		
		log.info("cnt" + result);
		
	}
	
	
	@Test
	@DisplayName("회원탈퇴")
	@Disabled
	void deleteMember() {
		String Member_Email = "test@test.com";
		String Member_pw = "1234";
		int result = memberDAO.deleteMember(Member_Email, Member_pw);
		
		log.info("cnt" + result);
	}
	
	
	@Test
	@DisplayName("회원아이디찾기")
	@Disabled
	void findMember_Email() {
		String Member_tel = "010-1111-1111";
		String Member_pw = "1234";
		String result = memberDAO.findMember_Email(Member_tel, Member_pw);
		
		log.info("Member_Email::" + result);
		
	}
	
	@Test
	@DisplayName("회비밀번호찾기")
	@Disabled
	void findMember_Pw() {
	
		String Member_Email = "test2@test.com";
		String Member_tel = "010-1111-1111";
		String Member_birth = "2020.04.16";
		String result = memberDAO.findMember_Pw(Member_Email, Member_tel, Member_birth);
		
		log.info("Member_Pw::" + result);
	
	}
	@Test
	@DisplayName("회원정보수정")
	@Disabled
	void modifyMember() {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMEMBER_NICKNAME("사용자");
		memberVO.setMEMBER_TEL("010-5555-5555");
		memberVO.setMEMBER_BIRTH(LocalDate.of(2021, 04, 01));
		memberVO.setMEMBER_GENDER("여");
		memberVO.setMEMBER_EMAIL("test2@test.com");
		memberVO.setMEMBER_PW("2345");
		int result = memberDAO.modifyMember(memberVO);
		
		log.info("cnt::"+ result);
		
	}
	
	@Test
	@DisplayName("회원비밀번호변경")
	@Disabled
	void changeMember_Pw() {
		String Member_Email = "test2@test.com";
		String Member_oldPw = "8888";
		String Member_newPw = "1234";
		int result = memberDAO.changeMember_Pw(Member_Email, Member_oldPw, Member_newPw);
		
		log.info("cnt::"+result);
	}
	
	@Test
	@DisplayName("로그인")
	@Disabled
	void login() {
		String MEMBER_EMAIL = "test2@test.com";
		String MEMBER_PW = "1234";
		boolean result = memberDAO.login(MEMBER_EMAIL, MEMBER_PW);
		log.info("cnt ::"+result);
	}
	
	@Test
	@DisplayName("조회")
	@Disabled
	void memberEmail() {
		String MEMBER_EMAIL = "test2@test.com";
		MemberVO result = memberDAO.memberEmail(MEMBER_EMAIL);
		log.info("content::"+result);
	}
	@Test
	@DisplayName("존재")
	@Disabled
	void existEmail() {
		String MEMBER_EMAIL = "test2@test.com";
		boolean result = memberDAO.existMember(MEMBER_EMAIL);
		log.info("content::"+result);
	}
	@Autowired
	CodeDAO codeDAO;

	@Autowired
	CodeSVC codeSVC;
	@Test
	@DisplayName("코드목록조회by코드유형")
	void getCodesByCodetype() {
		
		List<CodeVO> list = codeSVC.getcodeByCodetype("1000");
		log.info("값이 안나오나요?");
		log.info("값은? " + list.toString());
		for(CodeVO list2 : list) {
			log.info(list2.toString());
		}
	}
}
