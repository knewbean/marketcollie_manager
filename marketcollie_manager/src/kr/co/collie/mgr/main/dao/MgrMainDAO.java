package kr.co.collie.mgr.main.dao;

import java.security.NoSuchAlgorithmException;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.mgr.dao.GetCollieHandler;
import kr.co.collie.mgr.main.vo.MgrLoginVO;
import kr.co.sist.util.cipher.DataEncrypt;

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
	 * @param loginVO
	 * @return ������ id ��ȯ
	 */
	public String selectMgrLogin(MgrLoginVO loginVO) {
		String mgrId = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mgrId = ss.selectOne("selectMgrId", loginVO);
		ss.close();
		return mgrId;
	}
	
}
