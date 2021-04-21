package com.kh.portfolio.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.portfolio.member.svc.MemberSVC;
import com.kh.portfolio.member.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberSVC memberSVC;
	
	//회원가입페이지
	@GetMapping("/joinMember")
	public String joinMember() {
		
		return "/member/joinMember";
	}
	//회원가입처리
	@PostMapping("/joinSave")
	public String joingSave(MemberVO memberVO) {
		
		int result = 0;
		result = memberSVC.joinMember(memberVO);
		if(result == 0) {
			return "/member/joinMember";
		}
		
		return "/index";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("MEMBER_EMAIL") String MEMBER_EMAIL,
			@RequestParam("MEMBER_PW") String MEMBER_PW,
			Model model,
			HttpSession session
			) {
		log.info("id" + MEMBER_EMAIL);
		log.info("pw" + MEMBER_PW);
		if(memberSVC.existMember(MEMBER_EMAIL)) {
			model.addAttribute("svr_msg","");
		// 회원이 맞으면
		if(memberSVC.login(MEMBER_EMAIL, MEMBER_PW)) {
		 session.setAttribute("member", memberSVC.memberEmail(MEMBER_EMAIL));
			
			//model.addAttribute("member",memberSVC.memberEmail(MEMBER_EMAIL));
			return "/index";
		}else {
			model.addAttribute("svr_msg","가입되지 않은 ID 또는 비밀번호입니다.");
			return "/index";
		}
		}else {
			return "/home";
		}
		}
	
	

	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout:::");
		//세션에 저장된 정보 제거
		session.invalidate();
		
		return "redirect:/";
	
}
}