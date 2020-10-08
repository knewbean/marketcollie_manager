package kr.co.collie.mgr.review.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;
import kr.co.collie.mgr.review.dao.MgrReviewDAO;
import kr.co.collie.mgr.review.domain.MgrReviewDetailDomain;
import kr.co.collie.mgr.review.domain.MgrReviewListDomain;

public class MgrReviewService {
	
	/**
	 * 상품리뷰 목록을 불러오는 일
	 * @param rVO
	 * @return
	 */
	public List<MgrReviewListDomain> getReviewList(RangeVO rVO){
		List<MgrReviewListDomain> list = null;
		MgrReviewDAO mrDAO = MgrReviewDAO.getInstance();
		list = mrDAO.selectReviewList(rVO);
		
		return list;
	}//getReviewList
	
	/**
	 * 상품리뷰 목록 개수를 세는 일
	 * @param rVO
	 * @return
	 */
	public int getReviewListCnt(RangeVO rVO) {
		int cnt = 0;
		MgrReviewDAO mrDAO = MgrReviewDAO.getInstance();
		cnt = mrDAO.selectReviewListCnt(rVO);
		
		return cnt;
	}//getReviewListCnt
	
	/**
	 * 페이지네이션
	 * @return
	 */
	public String moveReviewList(int item_num, int current_page) {
		JSONObject json = new JSONObject();
		
		RangeVO rVO = new RangeVO(current_page, "item_num", String.valueOf(item_num));
		List<MgrReviewListDomain> list = MgrReviewDAO.getInstance().selectReviewList(rVO);
		
		String flag = "fail";
		if( list != null ) {
			flag = "success";
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = null;
			for(int i=0; i<list.size(); i++) {
				jsonObj = new JSONObject();
				jsonObj.put("review_num", list.get(i).getReview_num());
				jsonObj.put("id", list.get(i).getId());
				jsonObj.put("review_subject", list.get(i).getReview_subject());
				jsonObj.put("input_date", list.get(i).getInput_date());
				jsonArr.add(jsonObj);
			}//end for
			json.put("review_list", jsonArr);
			
			int total_cnt = MgrReviewDAO.getInstance().selectReviewListCnt(rVO);
			PaginationService ps = new PaginationService();
			String pagination = ps.getPagination(current_page, total_cnt);
			json.put("paging", pagination);
			
		}//end if
		
		json.put("flag", flag);
		return json.toJSONString();
	}//moveReviewList
	
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
