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
	 * ������� ��� ���ǻ����� ��ȸ�Ѵ�.
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
	 * ���� ��ȣ�� �ش��ϴ� ���ǻ����� �� ������ ��ȸ�Ѵ�.
	 * @param qna_num ���� ��ȣ
	 * @return {@link MgrQnaDetailDomain} ���ǻ����� �� ����
	 */
	public MgrQnaDetailDomain selectQnaDetail(int qna_num) {
		MgrQnaDetailDomain mqdd = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mqdd = ss.selectOne("selectQnaDetail", qna_num);
		ss.close();
		return mqdd;
	}
	
	/**
	 * ���� ��ȣ�� �ش��ϴ� ���� ������ �亯�� �����Ѵ�.
	 * @param mmqrVO ���� ���� �亯�� ���� ���� ���� VO
	 * @return ���� ��� ����
	 */
	public int updateQnaReply(MgrModifyQnaReplyVO mmqrVO) {
		int result = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		result = ss.update("updateQnaReply", mmqrVO);
		ss.commit();
		return result;
	}
	
}
