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
	 * MEMBER 테이블에서 아이디, 비밀번호와 일치하는 레코드의 MEMBER_FLAG의 컬럼 값을 조회한다. 
	 * 
	 * @param loginVO 관리자 아이디 비밀번호를 가진 VO
	 * @return member_flag 반환
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
