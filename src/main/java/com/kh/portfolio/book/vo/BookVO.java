package com.kh.portfolio.book.vo;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private String MEMBER_NUM;	//VARCHAR2(20 BYTE)
	private String BOOK_NUM;	//VARCHAR2(20 BYTE)
	private String BOOK_KO_NAME;	//VARCHAR2(100 BYTE)
	private String BOOK_EN_NAME;	//VARCHAR2(100 BYTE)
	private String BOOK_KO_AUHTHOR;	//VARCHAR2(30 BYTE)
	private String BOOK_EN_AUHTHOR;	//VARCHAR2(30 BYTE)
	private int BOOK_LEVEL;	//NUMBER(2,0)
	private String BOOK_KO_CONTENT;	//CLOB
	private String BOOK_EN_CONTENT;	//CLOB
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp BOOK_CDATE;	//TIMESTAMP(6)
	
	private String BOOK_FTYPE;	//VARCHAR2(50 BYTE)
	private String BOOK_FSIZE;	//VARCHAR2(50 BYTE)
	private byte[] BOOK_PIC;	//BLOB
	private String BOOK_FNAME;	//VARCHAR2(50 BYTE)
	
	//view에 이미지를 보여주기한 용도
	private String picbase64;
}
