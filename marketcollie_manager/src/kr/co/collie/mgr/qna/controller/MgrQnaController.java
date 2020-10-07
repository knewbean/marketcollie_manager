package kr.co.collie.mgr.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.collie.mgr.qna.domain.MgrQnaDetailDomain;
import kr.co.collie.mgr.qna.service.MgrQnaService;
import kr.co.collie.mgr.qna.vo.MgrModifyQnaReplyVO;

@Controller
public class MgrQnaController {

	@RequestMapping(value="/qna/list.do")
	public String getAllQna(Model model) {
		MgrQnaService mqs = new MgrQnaService();
		model.addAttribute("qna_list", mqs.getAllQna());
		return "/qna/qna_list";
	}
	
	@RequestMapping(value="/qna/detail.do")
	public String getQnaDetail(int qna_num, Model model) throws NumberFormatException {
		MgrQnaService mqs = new MgrQnaService();
		MgrQnaDetailDomain mqdd = mqs.getQnaDetail(qna_num);
		model.addAttribute("qna_info", mqdd);
		return "/qna/qna_detail";
	}
	
	@RequestMapping(value="/qna/modify_reply.do", method = RequestMethod.POST)
	public String modifyQnaReply(MgrModifyQnaReplyVO mmqrVO, Model model) throws NumberFormatException {
		MgrQnaService mqs = new MgrQnaService();
		boolean result = mqs.modifyQnaReply(mmqrVO);
		model.addAttribute("modify_result", result);
		return "/qna/qna_process";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String catchParsingException(NumberFormatException nfe) {
		return "/err/pasing_excect";
	}
	
}
