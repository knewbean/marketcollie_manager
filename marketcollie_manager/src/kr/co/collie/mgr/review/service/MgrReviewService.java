package kr.co.collie.mgr.review.service;

import kr.co.collie.mgr.review.dao.MgrReviewDAO;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;

public class MgrReviewService {
	
	/**
	 * ��ǰ���� �󼼳����� Ȯ���ϴ� ��
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
	 * ��ǰ���並 �����ϴ� ��
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
