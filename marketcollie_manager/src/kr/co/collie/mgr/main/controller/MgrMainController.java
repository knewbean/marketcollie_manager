package kr.co.collie.mgr.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.collie.mgr.main.vo.MgrLoginVO;

@Controller
public class MgrMainController {
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index() {
		System.out.println("controller main");
		//로그인 페이지로 이동
		return "login_frm";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MgrLoginVO mlVO) {
		String url = null;
		// 로그인 정보 유효성 검증 
		if(mlVO != null) {//로그인 정보가 있으면 관리자 메인 페이지로 이동
			url = "redirect:/main.do";
		} else {//로그인 정보가 없으면 다시 로그인 페이지로 이동
			url = "redirect:/index.do";
		}
		return url;
	}

	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() {
		return "main/index";
	}
	
	@RequestMapping(value="/header.do")
	public String getHeader() {
		return "common/header";
	}
	
}
