package kr.co.collie.mgr.review.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;

public class MgrReviewDAO {
	
	private static MgrReviewDAO mrDAO;
	
	private MgrReviewDAO() {
	}//MgrReviewDAO
	
	public static MgrReviewDAO getInstance() {
		if( mrDAO == null ) {
			mrDAO = new MgrReviewDAO();
		}//end if
		return mrDAO;
	}//getInstance
	
	/**
	 * 상품리뷰 상세내용을 확인하는 일
	 * @param review_num
	 * @return
	 */
	public MgrReviewDetailDomain selectReviewDetail(int review_num) {
		MgrReviewDetailDomain mrdd = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mrdd = ss.selectOne("kr.co.collie.mgr.review.selectReviewDetail", review_num);
		ss.close();
		
		return mrdd;
	}//selectReviewDetail
	
	/**
	 * 상품리뷰를 삭제하는 일
	 * @param review_num
	 * @return
	 */
	public int deleteReview(int review_num) {
		int cnt = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.delete("kr.co.collie.mgr.review.deleteReview", review_num);
		ss.commit();
		ss.close();
		
		return cnt;
	}//deleteReview
	
	public static void main(String[] args) {
		MgrReviewDAO mrDAO = new MgrReviewDAO();
		int review_num = 1;
		
		System.out.println(mrDAO.selectReviewDetail(review_num));
	}//main	
	
}//class
