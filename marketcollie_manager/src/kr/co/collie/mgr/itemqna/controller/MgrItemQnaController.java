package kr.co.collie.mgr.itemqna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.collie.mgr.itemqna.domain.MgrItemQnaDetailDomain;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaListDomain;
import kr.co.collie.mgr.itemqna.service.MgrItemQnaService;
import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@Controller
//@RestController
public class MgrItemQnaController {
	
	/**
	 * 상품문의 목록을 불러오는 일
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/list.do", method=GET)
	public String getItemQnaList(int item_num, Model model) {
		List<MgrItemQnaListDomain> list = null;
		
		int current_page = 1;
		RangeVO rVO = new RangeVO(current_page, "item_num", String.valueOf(item_num));
		list = new MgrItemQnaService().getItemQnaList(rVO);
		model.addAttribute("item_qna_list", list);
		
		//페이지네이션
		int total_cnt = 0;
		total_cnt = new MgrItemQnaService().getItemQnaListCnt(rVO);
		String pagination = new PaginationService().getPagination(current_page, total_cnt);
		model.addAttribute("paging", pagination);
		
		return "item_qna/item_qna_list";
	}//getItemQnaList
	
	/**
	 * 페이지네이션
	 * @param item_num
	 * @param current_page
	 * @return
	 */
	@RequestMapping(value="/item_qna/move_item_qna_list.do", method=GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String moveItemQnaList(int item_num, int current_page) {
		String json = null;
		json = new MgrItemQnaService().moveItemQnaList(item_num, current_page);
		
		return json;
	}//moveItemQnaList
	
	/**
	 * 상품문의 상세내용을 확인하는 일
	 * @param item_qna_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/detail.do", method=GET)
	public String viewItemQnaDetail(int item_qna_num, Model model) {
		MgrItemQnaService miqs = new MgrItemQnaService();
		MgrItemQnaDetailDomain miqdd = miqs.viewItemQnaDetail(item_qna_num);
		model.addAttribute("item_qna_detail", miqdd);
		
		return "item_qna/item_qna_detail";
	}//viewItemQnaDetail
	
	/**
	 * 상품문의 답변을 등록 및 수정하는 일
	 * @param miquVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/update_reply.do", method=POST)
	public String modifyItemQnaReply(MgrItemQnaUpdateVO miquVO, Model model) {
		MgrItemQnaService miqs = new MgrItemQnaService();
		boolean flag = miqs.modifyItemQnaReply(miquVO);
		model.addAttribute("updateFlag", flag);
		
		return "item_qna/item_qna_list";
	}//modifyItemQnaReply
	
}//class
