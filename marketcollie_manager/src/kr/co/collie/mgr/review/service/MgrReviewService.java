package kr.co.collie.mgr.review.service;

import kr.co.collie.mgr.review.dao.MgrReviewDAO;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;

public class MgrReviewService {
	
	/**
	 * 상품리뷰 상세내용을 확인하는 일
	 * @param review_num
	 * @return
	 */
	public MgrReviewDetailDomain viewReviewDetail(int review_num) {
		MgrReviewDetailDomain mrdd = null;
		MgrReviewDAO mrDAO = MgrReviewDAO.getInstance();
		mrdd = mrDAO.selectReviewDetail(review_num);
		
		return mrdd;
	}//viewReviewDetail
	
	/**
	 * 상품리뷰를 삭제하는 일
	 * @param review_num
	 * @return
	 */
	public boolean removeReview(int review_num) {
		boolean flag = false;
		MgrReviewDAO mrDAO = MgrReviewDAO.getInstance();
		flag = mrDAO.deleteReview(review_num)==1;
		
		return flag;
	}//removeReview
	
}//class
