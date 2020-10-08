package kr.co.collie.mgr.review.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;
import kr.co.collie.mgr.review.domain.MgrReviewListDomain;
import kr.co.collie.mgr.review.service.MgrReviewService;

@Controller
public class MgrReviewController {
	
	/**
	 * 상품리뷰 목록을 불러오는 일
	 * @param mrVO
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/review/list.do", method=GET)
	public String getReviewList(int item_num, Model model) {
		MgrReviewService mrs = new MgrReviewService();
		
		int current_page = 1;
		RangeVO rVO = new RangeVO(current_page, "item_num", String.valueOf(item_num));
		List<MgrReviewListDomain> list = mrs.getReviewList(rVO);
		model.addAttribute("review_list", list);
		
		//pagination
		int total_cnt = mrs.getReviewListCnt(rVO);
		PaginationService ps = new PaginationService();
		String pagination = ps.getPagination(current_page, total_cnt);
		model.addAttribute("paging", pagination);
		
		return "review/review_list";
	}//getReviewList
	
	/**
	 * 페이지네이션
	 * @param item_num
	 * @param current_page
	 * @return
	 */
	@RequestMapping(value="/review/move_review_list.do", method=POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String moveReviewList(int item_num, int current_page) {
		String json = null;
		json = new MgrReviewService().moveReviewList(item_num, current_page);
				
		return json;
	}//moveReviewList
	
	/**
	 * 상품리뷰 상세내용을 확인하는 일
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
	 * 상품리뷰를 삭제하는 일
	 * @param review_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/review/delete_review.do", method=POST)
	public String removeReview(int review_num) {
		MgrReviewService mrs = new MgrReviewService();
		boolean flag = mrs.removeReview(review_num); //실패하면 에러페이지로 보내기 ExceptionHandler
		
		return "review/review_list";
	}//removeReview
	
}//class
