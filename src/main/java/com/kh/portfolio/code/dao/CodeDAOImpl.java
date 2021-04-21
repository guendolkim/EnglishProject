package com.kh.portfolio.code.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.code.vo.CodeVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CodeDAOImpl implements CodeDAO {

	private final JdbcTemplate jt;
	
	//코드목록 가져오기
	@Override
	public List<CodeVO> getcodeByCodetype(String codetype_id) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select t1.code_id, t1.name from code t1, codetype t2 ");
		sql.append("where t1.codetype_id = t2.codetype_id ");
		sql.append("and t2.codetype_id = ? ");
		
		return jt.query(sql.toString(), new BeanPropertyRowMapper<CodeVO>(CodeVO.class),codetype_id);
	}
}
