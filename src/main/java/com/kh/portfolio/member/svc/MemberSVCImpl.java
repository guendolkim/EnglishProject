package com.kh.portfolio.member.svc;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

@Service
public class MemberSVCImpl implements MemberSVC {

	@Autowired
	MemberDAO memberDAO;
	
	
	/**
	 * 회원등록
	 * @param memberVO
	 * @return
	 */
	@Override
	public int joinMember(MemberVO memberVO) {
		
		
		//첨부 파일 존재시(회원프로파일사진) multipartfile에서 첨부파일관련 정보 추출
		if(memberVO.getFile().getSize() > 0) {

			try {
				//파일사이즈
				memberVO.setMEMBER_FSIZE(String.valueOf(memberVO.getFile().getSize()));
				//파일타입
				memberVO.setMEMBER_FTYPE(memberVO.getFile().getContentType());
				//파일이름
				memberVO.setMEMBER_FNAME(memberVO.getFile().getOriginalFilename());
				//첨부파일
				memberVO.setMEMBER_PIC(memberVO.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return memberDAO.joinMember(memberVO);
	}
	
	
	//이미지 base64로 변환후 img태그에 적용하기위함
		//Base64의 핵심은 바이너리 데이터를 ASCII코드로 변경하는 인코딩방식
		private String conversionToBase64(byte[] pic) {
			byte[] encoded = Base64.encodeBase64(pic);
			return new String(encoded);
		}
		

		/**
		 * 로그인
		 * @param Member_Email
		 * @param Member_Pw
		 * @return
		 */
		@Override
		public boolean login(String MEMBER_EMAIL, String MEMBER_PW) {
			
			return memberDAO.login(MEMBER_EMAIL, MEMBER_PW);
		}
		

		/**
		 * 조회
		 * @param MEMBER_EMAIL
		 * @return
		 */
		@Override
		public MemberVO memberEmail(String MEMBER_EMAIL) {
			MemberVO memberVO = memberDAO.memberEmail(MEMBER_EMAIL);
			
			//프로파일사진이 있으면 이미지파일 -> base64변환
			if(memberVO.getMEMBER_PIC() != null) {
				memberVO.setPicbase64(conversionToBase64(memberVO.getMEMBER_PIC()));
			}
			return memberVO;
		}
		
		@Override
		public boolean existMember(String MEMBER_EMAIL) {
	
			return memberDAO.existMember(MEMBER_EMAIL);
		}
}
