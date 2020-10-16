package kr.co.collie.mgr.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.category.service.MgrCategoryService;
import kr.co.collie.mgr.main.service.MgrMainService;
import kr.co.collie.mgr.member.domain.MgrMemberDetailDomain;
import kr.co.collie.mgr.member.domain.MgrMemberListDomain;
import kr.co.collie.mgr.member.service.MgrMemberService;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.pagination.TotalCntVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@Controller
public class MgrMemberController {
	
	@RequestMapping(value="/member/list.do", method=GET)
	public String getMemberList(Model model) {
		
		int current_page=1;
		RangeVO rVO=new RangeVO(1);
		List<MgrMemberListDomain> list=new MgrMemberService().getMemberList(rVO);
		model.addAttribute("member_list", list);
		
		PaginationService ps=new PaginationService();
		String pagination=ps.getPagination(current_page, new TotalCntVO("member", "member_flag", "Y"));
		model.addAttribute("paging", pagination);
		
		return "member/view_member_list";
	}//getMemberList
	
	@RequestMapping(value="/member/move_list.do", method=POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String moveMemberList(int current_page) throws NumberFormatException {
		String json=null;
		json=new MgrMemberService().moveMemberList(current_page);
		return json;
	}//moveCategoryList
	
	@RequestMapping(value="/member/detail.do", method=GET)
	public String getMemberDetail(int member_num, Model model) throws NumberFormatException {
		
		MgrMemberDetailDomain mmdd=new MgrMemberService().getMemberDetail(member_num);
		model.addAttribute("mem_detail", mmdd);
		
		return "member/view_member_detail";
	}//getMemberDetail
	
}//class
