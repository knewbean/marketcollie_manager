package kr.co.collie.mgr.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MgrMainController {
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String main() {
		return "main";
	}

}
