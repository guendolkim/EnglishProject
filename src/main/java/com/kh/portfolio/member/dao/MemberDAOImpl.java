package com.kh.portfolio.member.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	
	private final JdbcTemplate jt;
	
	/**
	 * 회원등록
	 * @param memberVO
	 * @return
	 */
	@Override
	public int joinMember(MemberVO memberVO) {
				
				//sql문 생성
				StringBuilder sql = new StringBuilder();
				
				sql.append("INSERT INTO member ( ");
				sql.append("    member_num, ");
				sql.append("    member_email, ");
				sql.append("    member_pw, ");
				sql.append("    member_nickname, ");
				sql.append("    member_birth, ");
				sql.append("    member_tel, ");
				sql.append("    member_gender, ");
				sql.append("    member_pic, ");
				sql.append("    member_fname, ");
				sql.append("    member_ftype, ");
				sql.append("    member_fsize ");
				sql.append(") VALUES ( ");
				sql.append("    'member_'||MEMBER_NUM_SEQ.nextval, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ?, ");
				sql.append("    ? ");
				sql.append(") ");
				
				int result = jt.update(sql.toString(),memberVO.getMEMBER_EMAIL(),
										 memberVO.getMEMBER_PW(),
										 memberVO.getMEMBER_NICKNAME(),
										 memberVO.getMEMBER_BIRTH(),
										 memberVO.getMEMBER_TEL(),
										 memberVO.getMEMBER_GENDER(),
										 memberVO.getMEMBER_PIC(),
										 memberVO.getMEMBER_FNAME(),
										 memberVO.getMEMBER_FTYPE(),
										 memberVO.getMEMBER_FSIZE());
				
				return result;
			}
	
	/**
	 * 회원삭제
	 * @param Member_Email
	 * @return
	 */
	@Override
	public int deleteMember(String Member_Email, String Member_pw) {
		
		StringBuilder sql = new StringBuilder();
		
	    sql.append("DELETE FROM member ");
	    sql.append("WHERE ");
	    sql.append("member_email = ? ");
	    sql.append("AND member_pw = ? ");
	    
	    int result = jt.update(sql.toString(), Member_Email, Member_pw);
		
		return result;
		
	}
	
	/**
	 * 회원아이디찾기
	 * @param Member_tel
	 * @param Member_pw
	 * @return
	 */
	@Override
	public String findMember_Email(String Member_tel, String Member_pw) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT member_email ");
		sql.append("FROM member ");
		sql.append("where member_tel = ? ");
		sql.append("and member_pw = ? ");
		
		String result = jt.queryForObject(sql.toString(), String.class, Member_tel, Member_pw);
		
		return result;
	}
	
	/**
	 * 회원비밀번호찾기
	 * @param Member_Email
	 * @param Member_tel
	 * @param Member_birth
	 * @return
	 */
	@Override
	public String findMember_Pw(String Member_Email, String Member_tel, String Member_birth) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT member_pw ");
		sql.append("FROM member ");
		sql.append("where member_email = ? ");
		sql.append("and member_tel = ? ");
		sql.append("and member_birth = ? ");
				
		return jt.queryForObject(sql.toString(), String.class, Member_Email, Member_tel, Member_birth);
	}
	
	/**
	 * 회원수정
	 * @param memberVO
	 * @return
	 */
	@Override
	public int modifyMember(MemberVO memberVO) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE member ");
		sql.append("SET member_nickname = ?, ");
		sql.append("    member_birth = ?, ");
		sql.append("    member_tel = ?, ");
		sql.append("    member_gender = ?, ");
		sql.append("    member_udate = systimestamp, ");
		sql.append("    member_pic = ?, ");
		sql.append("    member_fname = ?, ");
		sql.append("    member_ftype = ?, ");
		sql.append("    member_fsize = ? ");
		sql.append("where member_email = ? ");
		sql.append("    and member_pw = ?    ");
		
		int result = jt.update(sql.toString(),
								 memberVO.getMEMBER_NICKNAME(),
								 memberVO.getMEMBER_BIRTH(),
								 memberVO.getMEMBER_TEL(),
								 memberVO.getMEMBER_GENDER(),
								 memberVO.getMEMBER_PIC(),
								 memberVO.getMEMBER_FNAME(),
								 memberVO.getMEMBER_FTYPE(),
								 memberVO.getMEMBER_FSIZE(),
								 memberVO.getMEMBER_EMAIL(),
								 memberVO.getMEMBER_PW());
		
		return result;
	}
	
	/**
	 * 비밀번호수정
	 * @param Member_Email
	 * @param Member_oldPw
	 * @param Member_newPw
	 * @return
	 */
	@Override
	public int changeMember_Pw(String Member_Email, String Member_oldPw, String Member_newPw) {
		
		StringBuilder sql = new StringBuilder();
		
	    sql.append("update member  ");
	    sql.append("set member_pw = ? ");
	    sql.append("where member_email = ? ");
	    sql.append("and member_pw = ? ");	    
	    
		return jt.update(sql.toString(),Member_newPw,Member_Email,Member_oldPw);
	}
	
	
	/**
	 * 로그인
	 * @param Member_Email
	 * @param Member_Pw
	 * @return
	 */
	@Override
	public boolean login(String Member_Email, String Member_Pw) {
		
//		StringBuilder sql = new StringBuilder();
//		
//		sql.append("select count(*) ");
//		sql.append("from member ");
//		sql.append("where member_email = ? ");
//		sql.append("and member_pw = ? ");
		
		String sql = "select count(*) cnt from member where Member_Email = ? and Member_Pw = ?";
		Integer cnt = jt.queryForObject(sql, Integer.class,Member_Email,Member_Pw);
		boolean result =false;
		result = (cnt ==1)?true:false;
		return result;
	}
	
	/**
	 * 아이디가져오기
	 * @param MEMBER_EMAIL
	 * @return
	 */
	@Override
	public MemberVO memberEmail(String MEMBER_EMAIL) {

		String sql = "select * from member where member_email = ? ";
		
		MemberVO result = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<MemberVO>(MemberVO.class),MEMBER_EMAIL);
		return result;
	}
	
	//회원 존재
		@Override
		public boolean existMember(String MEMBER_EMAIL) {
			boolean result = false;
			String sql ="select count(*) cnt from member where MEMBER_EMAIL = ? ";
			Integer cnt = jt.queryForObject(sql, Integer.class, MEMBER_EMAIL);
			result = (cnt == 1) ? true : false;		
			return result;
		}
}
