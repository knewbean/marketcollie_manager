package kr.co.collie.mgr.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.qna.domain.MgrQnaDetailDomain;
import kr.co.collie.mgr.qna.domain.MgrQnaListDomain;
import kr.co.collie.mgr.qna.vo.MgrModifyQnaReplyVO;

public class MgrQnaDAO {
	
	private static MgrQnaDAO mqDAO;

	private MgrQnaDAO() {
	}
	
	public static MgrQnaDAO getInstance() {
		if(mqDAO == null) {
			mqDAO = new MgrQnaDAO();
		}
		return mqDAO;
	}
	
	
	/**
	 * 사용자의 모든 문의사항을 조회한다.
	 * @return
	 */
	public List<MgrQnaListDomain> selectAllQna() {
		List<MgrQnaListDomain> list = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		list = ss.selectList("selectQnaList");
		ss.close();
		return list;
	}
	
	
	/**
	 * 문의 번호에 해당하는 문의사항의 상세 정보를 조회한다.
	 * @param qna_num 문의 번호
	 * @return {@link MgrQnaDetailDomain} 문의사항의 상세 정보
	 */
	public MgrQnaDetailDomain selectQnaDetail(int qna_num) {
		MgrQnaDetailDomain mqdd = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mqdd = ss.selectOne("selectQnaDetail", qna_num);
		ss.close();
		return mqdd;
	}
	
	/**
	 * 문의 번호에 해당하는 문의 사항의 답변을 수정한다.
	 * @param mmqrVO 문의 사항 답변에 대한 값을 가진 VO
	 * @return 수정 결과 갯수
	 */
	public int updateQnaReply(MgrModifyQnaReplyVO mmqrVO) {
		int result = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		result = ss.update("updateQnaReply", mmqrVO);
		ss.commit();
		return result;
	}
	
}
