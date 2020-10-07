package kr.co.collie.mgr.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;
import kr.co.collie.mgr.review.service.MgrReviewService;
import kr.co.collie.mgr.review.vo.MgrReviewVO;

@Controller
public class MgrReviewController {
	
	/**
	 * ��ǰ���� ����� �ҷ����� ��
	 * @param mrVO
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/review/list.do", method=GET)
//	public String getReviewList(MgrReviewVO mrVO, int currentPage, Model model) {
	public String getReviewList(MgrReviewVO mrVO, Model model) {
		
		return "review/review_list";
	}//getReviewList
	
	/**
	 * ��ǰ���� �󼼳����� Ȯ���ϴ� ��
	 * @param review_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/review/detail.do", method=GET)
	public String viewReviewDetail(int review_num, Model model) {
		MgrReviewService mrs = new MgrReviewService();
		MgrReviewDetailDomain mrdd = mrs.viewReviewDetail(review_num);
		model.addAttribute("review_detail", mrdd);
		
		return "review/review_detail";
	}//viewReviewDetail
	
	/**
	 * ��ǰ���並 �����ϴ� ��
	 * @param review_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/review/delete_review.do", method=POST)
	public String removeReview(int review_num) {
		MgrReviewService mrs = new MgrReviewService();
		boolean flag = mrs.removeReview(review_num); //�����ϸ� ������������ ������ ExceptionHandler
		
		return "review/review_list";
	}//removeReview
	
}//class
