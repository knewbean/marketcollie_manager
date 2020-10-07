package kr.co.collie.mgr.main.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.main.domain.MgrLoginDomain;
import kr.co.collie.mgr.main.vo.MgrLoginVO;

public class MgrMainDAO {

	private static MgrMainDAO mDAO;
	
	private MgrMainDAO() {
	}
	
	public static MgrMainDAO getInstance() {
		if(mDAO == null) {
			mDAO = new MgrMainDAO();
		}
		return mDAO;
	}

	/**
	 * 
	 * MEMBER ���̺��� ���̵�, ��й�ȣ�� ��ġ�ϴ� ���ڵ��� MEMBER_FLAG�� �÷� ���� ��ȸ�Ѵ�. 
	 * 
	 * @param loginVO ������ ���̵� ��й�ȣ�� ���� VO
	 * @return member_flag ��ȯ
	 */
	public MgrLoginDomain selectMgrLogin(MgrLoginVO loginVO) {
		MgrLoginDomain mgrDomain = null;
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mgrDomain = ss.selectOne("selectMgrId", loginVO);
		ss.close();
		return mgrDomain;
	}
	
	
	public static void main(String[] args) {
		MgrLoginVO loginVO = new MgrLoginVO();
		loginVO.setId("test1");
		loginVO.setPass("1234");
		MgrLoginDomain mld = MgrMainDAO.getInstance().selectMgrLogin(loginVO);
		System.out.println(mld);
	}
}
