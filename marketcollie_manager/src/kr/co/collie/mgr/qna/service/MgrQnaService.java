package kr.co.collie.mgr.qna.service;

import java.util.List;

import kr.co.collie.mgr.qna.dao.MgrQnaDAO;
import kr.co.collie.mgr.qna.domain.MgrQnaDetailDomain;
import kr.co.collie.mgr.qna.domain.MgrQnaListDomain;
import kr.co.collie.mgr.qna.vo.MgrModifyQnaReplyVO;

public class MgrQnaService {
	
	/**
	 * 
	 * 모든 문의 사항을 조회한다.
	 * @return
	 */
	public List<MgrQnaListDomain> getAllQna() {
		List<MgrQnaListDomain> list = null;
		list = MgrQnaDAO.getInstance().selectAllQna();
		return list;
	}
	
	public MgrQnaDetailDomain getQnaDetail(int qna_num) {
		MgrQnaDetailDomain mqdd = null;
		mqdd = MgrQnaDAO.getInstance().selectQnaDetail(qna_num);
		return mqdd;
	}
	
	public boolean modifyQnaReply(MgrModifyQnaReplyVO mmqrVO) {
		MgrQnaDAO mqDAO = MgrQnaDAO.getInstance();
		if(mmqrVO.getQna_reply().trim().length() > 0) {
			mmqrVO.setQna_flag("Y");
		}
		int result = mqDAO.updateQnaReply(mmqrVO);
		return result != 0;
	}

}
