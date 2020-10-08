package kr.co.collie.mgr.main.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.collie.mgr.main.service.MgrMainService;
import kr.co.collie.mgr.main.vo.MgrLoginVO;

@Controller
@SessionAttributes({"mgr_id"})
public class MgrMainController {
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index() {
		System.out.println("로그인 페이지로 이동");
		//로그인 페이지로 이동
		return "login_frm";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MgrLoginVO mlVO, Model model) throws NoSuchAlgorithmException {
		MgrMainService mms = new MgrMainService();
		String mgrId = mms.loginMgr(mlVO);
		if(mgrId != null) {
			model.addAttribute("mgr_id", mgrId);
		}
		return "main/login_process";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session, SessionStatus ss) {
		session.invalidate();
		ss.setComplete();
		return "main/logout_process";
	}
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() {
		return "main/index";
	}
	
	@RequestMapping(value="/header.do")
	public String getHeader() {
		return "common/header";
	}
	
	
	@ExceptionHandler(NoSuchAlgorithmException.class)
	public String noSuchAligorithmExcept(NoSuchAlgorithmException nsae) {
		return "err/algorithm_except";
	}
	
	
}
