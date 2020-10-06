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
		MgrQnaDAO mqDAO = new MgrQnaDAO();
		list = mqDAO.selectAllQna();
		return list;
	}
	
	public MgrQnaDetailDomain getQnaDetail(int qna_num) {
		MgrQnaDetailDomain mqdd = null;
		MgrQnaDAO mqDAO = new MgrQnaDAO();
		mqdd = mqDAO.selectQnaDetail(qna_num);
		return mqdd;
	}
	
	public boolean modifyQnaReply(MgrModifyQnaReplyVO mmqrVO) {
		MgrQnaDAO mqDAO = new MgrQnaDAO();
		if(mmqrVO.getQna_reply().trim().length() > 0) {
			mmqrVO.setQna_reply("Y");
		}
		int result = mqDAO.updateQnaReply(mmqrVO);
		return result != 0;
	}

}
