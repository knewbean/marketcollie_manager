package kr.co.collie.mgr.itemqna.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.collie.mgr.itemqna.dao.MgrItemQnaDAO;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaDetailDomain;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaListDomain;
import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;
import kr.co.collie.mgr.pagination.PaginationService;
import kr.co.collie.mgr.pagination.RangeVO;

public class MgrItemQnaService {	
	
	/**
	 * 상품문의 목록을 불러오는 일
	 * @param rVO
	 * @return
	 */
	public List<MgrItemQnaListDomain> getItemQnaList(RangeVO rVO){
		List<MgrItemQnaListDomain> list = null;
		MgrItemQnaDAO miqDAO = MgrItemQnaDAO.getInstance();
		list = miqDAO.selectItemQnaList(rVO);
		
		return list;
	}//getItemQnaList
	
	/**
	 * 상품문의 목록 개수를 세는 일
	 * @param rVO
	 * @return
	 */
	public int getItemQnaListCnt(RangeVO rVO) {
		int cnt = 0;
		MgrItemQnaDAO miqDAO = MgrItemQnaDAO.getInstance();
		cnt = miqDAO.selectItemQnaListCnt(rVO);
		
		return cnt;
	}//getItemQnaListCnt
	
	/**
	 * 페이지네이션
	 * @param item_num
	 * @param current_page
	 * @return
	 */
	public String moveItemQnaList(int item_num, int current_page) {
		JSONObject json = new JSONObject();
		
		RangeVO rVO = new RangeVO(current_page, "item_num", String.valueOf(item_num));
		List<MgrItemQnaListDomain> list = MgrItemQnaDAO.getInstance().selectItemQnaList(rVO);
		
		String flag = "fail";
		if( list != null ) {
			flag = "success";
			JSONArray jsonArr = new JSONArray();
			JSONObject temp = null;
			for(MgrItemQnaListDomain miqld : list) {
				temp = new JSONObject();
				temp.put("item_qna_num", miqld.getItem_qna_num());
				temp.put("item_qna_subject", miqld.getItem_qna_subject());
				temp.put("id", miqld.getId());
				temp.put("item_qna_flag", miqld.getItem_qna_flag());
				jsonArr.add(temp);
			}//end for
			json.put("item_qna_list", jsonArr);
			
			int total_cnt = MgrItemQnaDAO.getInstance().selectItemQnaListCnt(rVO);
			String pagination = new PaginationService().getPagination(current_page, total_cnt);
			json.put("paging", pagination);
		}//end if
		
		json.put("flag", flag);
		
		return json.toJSONString();
	}//moveItemQnaList
	
	/**
	 * 상품문의 상세내용을 확인하는 일
	 * @param item_qna_num
	 * @return
	 */
	public MgrItemQnaDetailDomain viewItemQnaDetail(int item_qna_num) {
		MgrItemQnaDetailDomain miqdd = null;
		MgrItemQnaDAO miqDAO = MgrItemQnaDAO.getInstance();
		miqdd = miqDAO.selectItemQnaDetail(item_qna_num);
		
		return miqdd;
	}//viewItemQnaDetail
	
	/**
	 * 상품문의 답변을 등록 및 수정하는 일
	 * @param miquVO
	 * @return
	 */
	public boolean modifyItemQnaReply(MgrItemQnaUpdateVO miquVO) {
		boolean flag = false;
		MgrItemQnaDAO miqDAO = MgrItemQnaDAO.getInstance();
		flag = miqDAO.UpdateItemQnaReply(miquVO)==1;
		
		return flag;
	}//modifyItemQnaReply
	
}//class
