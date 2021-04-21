package com.kh.portfolio.code.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.portfolio.code.dao.CodeDAO;
import com.kh.portfolio.code.vo.CodeVO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CodeSVCImpl implements CodeSVC {

	private final CodeDAO codeDAO;
	
	@Override
	public List<CodeVO> getcodeByCodetype(String codetype_id) {
		
		return  codeDAO.getcodeByCodetype(codetype_id);
	}

}
