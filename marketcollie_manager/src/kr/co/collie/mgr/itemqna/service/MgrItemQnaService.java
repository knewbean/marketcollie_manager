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
	 * ��ǰ���� ����� �ҷ����� ��
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
	 * ��ǰ���� ��� ������ ���� ��
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
	 * ���������̼�
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
	 * ��ǰ���� �󼼳����� Ȯ���ϴ� ��
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
	 * ��ǰ���� �亯�� ��� �� �����ϴ� ��
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
