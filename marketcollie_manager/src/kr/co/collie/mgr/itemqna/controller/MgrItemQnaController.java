package kr.co.collie.mgr.itemqna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.collie.mgr.itemqna.domain.MgrItemQnaDetailDomain;
import kr.co.collie.mgr.itemqna.service.MgrItemQnaService;
import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MgrItemQnaController {
	
	/**
	 * 상품문의 목록을 불러오는 일
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/list.do", method=GET)
	public String getItemQnaList(Model model) {
		
		return "item_qna/item_qna_list";
	}//getItemQnaList
	
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
