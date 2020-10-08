package kr.co.collie.mgr.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;
import kr.co.collie.mgr.review.domain.MgrReviewListDomain;

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
	 * 상품리뷰 목록을 불러오는 일
	 * @param item_num
	 * @return
	 */
	public List<MgrReviewListDomain> selectReviewList(RangeVO rVO){
		List<MgrReviewListDomain> list = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.collie.mgr.review.selectReviewList", rVO);
		ss.close();
		
		return list;
	}//selectReviewList
	
	/**
	 * 상품리뷰 목록 개수를 세는 일
	 * @param rVO
	 * @return
	 */
	public int selectReviewListCnt(RangeVO rVO) {
		int cnt = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		cnt = ss.selectOne("kr.co.collie.mgr.review.selectReviewListCnt", rVO);
		ss.close();
		
		return cnt;
	}//selectReviewListCnt
	
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
		RangeVO rVO = new RangeVO(1, "item_num", "1");
		
		System.out.println(mrDAO.selectReviewListCnt(rVO));
	}//main	
	
}//class
