package kr.co.collie.mgr.itemqna.service;

import kr.co.collie.mgr.itemqna.dao.MgrItemQnaDAO;
import kr.co.collie.mgr.itemqna.domain.MgrItemQnaDetailDomain;
import kr.co.collie.mgr.itemqna.vo.MgrItemQnaUpdateVO;

public class MgrItemQnaService {	
	
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
