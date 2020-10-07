package kr.co.collie.mgr.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MgrMemeberController {
	
	@RequestMapping(value="/member/list.do", method=GET)
	public String getMemberList(Model model) {
		
		return "member/view_member_list";
	}//getMemberList
	
}//class
