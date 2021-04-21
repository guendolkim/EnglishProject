package com.kh.portfolio.code.svc;

import java.util.List;

import com.kh.portfolio.code.vo.CodeVO;

public interface CodeSVC {

	//코드유형을 코드목록으로 가져오기
		List<CodeVO> getcodeByCodetype(String codetype_id);
}
