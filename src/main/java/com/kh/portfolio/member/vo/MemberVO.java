package com.kh.portfolio.member.vo;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class MemberVO {

	private String MEMBER_NUM;	//VARCHAR2(20 BYTE)
	private String MEMBER_EMAIL;	//VARCHAR2(50 BYTE)
	private String MEMBER_PW;	//VARCHAR2(50 BYTE)
	private String MEMBER_NICKNAME;	//VARCHAR2(50 BYTE)
	private String MEMBER_TEL;	//VARCHAR2(30 BYTE)
	private String MEMBER_GENDER;	//VARCHAR2(3 BYTE)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate MEMBER_BIRTH;	//DATE
	private Timestamp MEMBER_CDATE;	//TIMESTAMP(6)
	private Timestamp MEMBER_UDATE;	//TIMESTAMP(6)
	
	private MultipartFile file;  //view에서 첨부파일을 바인딩하기위해 필요
	private byte[] MEMBER_PIC;	//BLOB
	private String MEMBER_FNAME;	//VARCHAR2(50 BYTE)
	private String MEMBER_FTYPE;	//VARCHAR2(50 BYTE)
	private String MEMBER_FSIZE;	//VARCHAR2(50 BYTE)
	
	//view에 이미지를 보여주기한 용도
	private String picbase64;
	
	
}
