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
		//�α��� �������� �̵�
		return "login_frm";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MgrLoginVO mlVO) {
		String url = null;
		// �α��� ���� ��ȿ�� ���� 
		if(mlVO != null) {//�α��� ������ ������ ������ ���� �������� �̵�
			url = "redirect:/main.do";
		} else {//�α��� ������ ������ �ٽ� �α��� �������� �̵�
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
