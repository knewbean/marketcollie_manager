package kr.co.collie.mgr.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MgrQnaController {

	@RequestMapping(value="/qna/list.do")
	public String showQnaList() {
		return "/qna/qna_list";
	}
	
}
