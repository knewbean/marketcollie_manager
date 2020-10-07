package kr.co.collie.mgr.itemqna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MgrItemQnaController {
	
	/**
	 * ��ǰ���� ����� �ҷ����� ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/list.do", method=GET)
	public String getItemQnaList(Model model) {
		
		return "item_qna/item_qna_list";
	}//getItemQnaList
	
	/**
	 * ��ǰ���� �󼼳����� Ȯ���ϴ� ��
	 * @param item_qna_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/detail.do", method=GET)
	public String viewItemQnaDetail(int item_qna_num, Model model) {
		
		return "item_qna/item_qna_detail";
	}//viewItemQnaDetail
	
	/**
	 * ��ǰ���� �亯 ������ ������Ʈ�ϴ� ��
	 * @param miquVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/item_qna/update_reply.do", method=GET)
	public String modifyItemQnaReply(MgrItemQnaUpdateVO miquVO, Model model) {
		
		return "item_qna/item_qna_list";
	}//modifyItemQnaReply
	
}//class
