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
	 * MEMBER 테이블에서 아이디, 비밀번호와 일치하는 레코드의 MEMBER_FLAG의 컬럼 값을 조회한다. 
	 * 
	 * @param loginVO
	 * @return 관리자 id 반환
	 */
	public String selectMgrLogin(MgrLoginVO loginVO) {
		String mgrId = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		mgrId = ss.selectOne("selectMgrId", loginVO);
		ss.close();
		return mgrId;
	}
	
}
