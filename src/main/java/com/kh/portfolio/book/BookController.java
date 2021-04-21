package com.kh.portfolio.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.portfolio.book.vo.BookVO;
import com.kh.portfolio.code.svc.CodeSVC;
import com.kh.portfolio.code.vo.CodeVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	private final CodeSVC codeSVC;
	

	
	//selector 자료
	@ModelAttribute
	public void selector(Model model) {
		model.addAttribute("difficult",codeSVC.getcodeByCodetype("1000") );
		
		
	}
	
	@GetMapping("/joinBook")
	public String joinBook(Model model) {
		BookVO bookVO = new BookVO();
		model.addAttribute("bookVO", bookVO);
		return "/book/joinBook";
	}
	
	
	
	
	
}
